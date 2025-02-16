package bck.api.safiderp.core.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import bck.api.safiderp.core.exception.GenericException;
import bck.api.safiderp.core.service.GenericService;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public abstract class GenericController<DTO, ID> {

    private final GenericService<?, ID, DTO> service;

    public GenericController(GenericService<?, ID, DTO> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> findById(@PathVariable ID id) {    	 
    	 DTO dto = service.findById(id); 
    	  return ResponseEntity.ok(dto);   	   
    }

    @PostMapping
    public ResponseEntity<DTO> save(@RequestBody DTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable ID id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}