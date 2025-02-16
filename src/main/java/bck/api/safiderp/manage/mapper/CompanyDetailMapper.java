package bck.api.safiderp.manage.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bck.api.safiderp.manage.dto.CompanyDetailDTO;
import bck.api.safiderp.manage.entity.ManaCompDeta;

@Component
public class CompanyDetailMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CompanyDetailDTO toDTO(ManaCompDeta entity) {
        return modelMapper.map(entity, CompanyDetailDTO.class);
    }

    public ManaCompDeta toEntity(CompanyDetailDTO dto) {
        return modelMapper.map(dto, ManaCompDeta.class);
    }
}