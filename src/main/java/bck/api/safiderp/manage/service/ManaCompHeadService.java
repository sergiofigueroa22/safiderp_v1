package bck.api.safiderp.manage.service;

import org.springframework.stereotype.Service;

import bck.api.safiderp.core.service.GenericService;
import bck.api.safiderp.manage.dto.CompanyHeadDTO;
import bck.api.safiderp.manage.entity.ManaCompHead;

@Service
public interface ManaCompHeadService extends GenericService<ManaCompHead, Long, CompanyHeadDTO> {
}