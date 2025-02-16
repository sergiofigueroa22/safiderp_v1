package bck.api.safiderp.manage.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bck.api.safiderp.manage.dto.CompanyHeadDTO;
import bck.api.safiderp.manage.entity.ManaCompHead;

@Component
public class CompanyHeadMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CompanyHeadDTO toDTO(ManaCompHead entity) {
        return modelMapper.map(entity, CompanyHeadDTO.class);
    }

    public ManaCompHead toEntity(CompanyHeadDTO dto) {
        return modelMapper.map(dto, ManaCompHead.class);
    }
}