package bck.api.safiderp.manage.service;

import org.springframework.stereotype.Service;

import bck.api.safiderp.core.service.GenericService;
import bck.api.safiderp.manage.dto.CompanyDetailDTO;
import bck.api.safiderp.manage.entity.ManaCompDeta;

@Service
public interface ManaCompDetaService extends GenericService<ManaCompDeta, Long, CompanyDetailDTO> {
}
