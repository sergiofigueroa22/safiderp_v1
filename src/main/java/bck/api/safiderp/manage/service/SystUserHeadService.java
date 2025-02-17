package bck.api.safiderp.manage.service;

import org.springframework.stereotype.Service;

import bck.api.safiderp.core.service.GenericService;
import bck.api.safiderp.manage.dto.SystUserHeadDTO;
import bck.api.safiderp.manage.entity.SystUserHead;

@Service
public interface SystUserHeadService extends GenericService<SystUserHead, Long, SystUserHeadDTO> {

}
