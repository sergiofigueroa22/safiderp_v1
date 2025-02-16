package bck.api.safiderp.core.service;

import java.util.List;

public interface GenericService<T, ID, DTO> {
    List<DTO> findAll();
    DTO findById(ID id);
    DTO save(DTO dto);
    void deleteById(ID id);
}