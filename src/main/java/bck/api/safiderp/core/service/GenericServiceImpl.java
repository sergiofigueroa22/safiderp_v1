package bck.api.safiderp.core.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import bck.api.safiderp.core.entity.BaseEntity;
import bck.api.safiderp.core.exception.GenericException;
import bck.api.safiderp.core.repository.GenericRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class GenericServiceImpl<T extends BaseEntity, ID extends Serializable, DTO> 
    implements GenericService<T, ID, DTO> {

    private final GenericRepository<T, ID> repository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private Validator validator;

    private final Class<T> entityClass;
    private final Class<DTO> dtoClass;

    public GenericServiceImpl(GenericRepository<T, ID> repository, Class<T> entityClass, Class<DTO> dtoClass) {
        this.repository = repository;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DTO> findAll() {
        try {
            return repository.findAll().stream()
                    .map(entity -> modelMapper.map(entity, dtoClass))
                    .collect(Collectors.toList());
        } catch (DataAccessException ex) {
            throw new GenericException("DATABASE_ERROR", "Error al acceder a los datos de " + entityClass.getSimpleName(), ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public DTO findById(ID id) {
        T entity = repository.findById(id)
                .orElseThrow(() -> new GenericException("NOT_FOUND",entityClass.getSimpleName() + " Registro no encontrado con ID: " + id));
        
        return modelMapper.map(entity, dtoClass);
    }

    @Override
    @Transactional
    public DTO save(DTO dto) {
        try {
            validateDTO(dto);            
            T entity = modelMapper.map(dto, entityClass);
            T savedEntity = repository.save(entity);
            validateEntity(savedEntity);
            
            return modelMapper.map(savedEntity, dtoClass);
            
        } catch (DataIntegrityViolationException ex) {
            throw new GenericException("DATA_INTEGRITY_VIOLATION", 
                "Error de integridad de datos al guardar " + entityClass.getSimpleName(), ex);
        } catch (DataAccessException ex) {
            throw new GenericException("DATABASE_ERROR", "Error al guardar " + entityClass.getSimpleName(), ex);
        }
    }

    @Override
    @Transactional
    public DTO update(ID id, DTO dto) {
        try {
            T existingEntity = repository.findById(id)
              .orElseThrow(() -> new GenericException("NOT_FOUND", entityClass.getSimpleName() + " Registro no encontrado para actualizar. ID: " + id));

            validateDTO(dto);
            
            modelMapper.map(dto, existingEntity);
            T updatedEntity = repository.save(existingEntity);
            validateEntity(updatedEntity);
            
            return modelMapper.map(updatedEntity, dtoClass);
            
        } catch (DataAccessException ex) {
            throw new GenericException("DATABASE_ERROR","Error al actualizar " + entityClass.getSimpleName(), ex);
        }
    }

    @Override
    @Transactional
    public void deleteById(ID id) {
        if (!repository.existsById(id)) {
            throw new GenericException("NOT_FOUND",entityClass.getSimpleName() + " Registro no encontrado para eliminar. ID: " + id);
        }
        
        try {
            repository.deleteById(id);
            validateDeletion(id);
        } catch (DataAccessException ex) {
            throw new GenericException("DATABASE_ERROR","Error al eliminar " + entityClass.getSimpleName(), ex);
        }
    }

    protected void validateDTO(DTO dto) {
        Set<ConstraintViolation<DTO>> violations = validator.validate(dto);
        if (!violations.isEmpty()) {
            String messages = violations.stream()
                    .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                    .collect(Collectors.joining("; "));
            throw new GenericException("VALIDATION_ERROR", "Validación DTO fallida en " + dtoClass.getSimpleName() + ": " + messages);
        }
    }

    protected void validateEntity(T entity) {
        Set<ConstraintViolation<T>> violations = validator.validate(entity);
        if (!violations.isEmpty()) {
            String messages = violations.stream()
                    .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                    .collect(Collectors.joining("; "));
            throw new GenericException("VALIDATION_ERROR", "Validación Entity fallida en " + entityClass.getSimpleName() + ": " + messages);
        }
    }

    protected void validateDeletion(ID id) {
        if (repository.existsById(id)) {
            throw new GenericException("DELETE_FAILED", "Falló la eliminación de " + entityClass.getSimpleName() + " con ID: " + id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DTO> findAllPaginated(Pageable pageable) {
        try {
            return repository.findAll(pageable)
                    .map(entity -> modelMapper.map(entity, dtoClass));
        } catch (DataAccessException ex) {
            throw new GenericException("DATABASE_ERROR", "Error en paginación de " + entityClass.getSimpleName(), ex);
        }
    }
}