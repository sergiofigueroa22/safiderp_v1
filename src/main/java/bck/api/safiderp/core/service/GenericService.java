package bck.api.safiderp.core.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericService<T, ID, DTO> {
    List<DTO> findAll();
    DTO findById(ID id);
    DTO save(DTO dto);
    void deleteById(ID id);
	Page<DTO> findAllPaginated(Pageable pageable);
	DTO update(ID id, DTO dto);
}