package bck.api.safiderp.core.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import bck.api.safiderp.core.entity.BaseEntity;
import bck.api.safiderp.core.exception.GenericException;
import bck.api.safiderp.core.repository.GenericRepository;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GenericServiceImpl<T extends BaseEntity, ID extends Serializable, DTO> implements GenericService<T, ID, DTO> {

    private final GenericRepository<T, ID> repository; 

    @Autowired
    private ModelMapper modelMapper;

    private final Class<T> entityClass;
    private final Class<DTO> dtoClass;

    public GenericServiceImpl(GenericRepository<T, ID> repository, Class<T> entityClass, Class<DTO> dtoClass) {
        this.repository = repository;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Override
    public List<DTO> findAll() {
        return repository.findAll().stream()
                .map(entity -> modelMapper.map(entity, dtoClass))
                .collect(Collectors.toList())
                ;
    }

    @Override
    public DTO findById(ID id) {
    	    T entity = repository.findById(id)
    	            .orElseThrow(() -> {
    	                return new GenericException("NOT_FOUND",entityClass.getSimpleName()+ " - ID Not Found: " + id);
    	            });
    	    return modelMapper.map(entity, dtoClass);
    }

    @Override
    public DTO save(DTO dto) {
        T entity = modelMapper.map(dto, entityClass);
        T savedEntity = repository.save(entity);
        return modelMapper.map(savedEntity, dtoClass);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}