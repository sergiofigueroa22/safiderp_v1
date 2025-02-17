package bck.api.safiderp.manage.service;

import bck.api.safiderp.core.service.GenericServiceImpl;
import bck.api.safiderp.manage.dto.CompanyHeadDTO;
import bck.api.safiderp.manage.entity.ManaCompHead;
import bck.api.safiderp.manage.repository.ManaCompHeadRepository;
import org.springframework.stereotype.Service;

@Service 
public class ManaCompHeadServiceImpl extends GenericServiceImpl<ManaCompHead, Long, CompanyHeadDTO> 
implements ManaCompHeadService {

    public ManaCompHeadServiceImpl(ManaCompHeadRepository repository) {
        super(repository, ManaCompHead.class, CompanyHeadDTO.class);
    }
}