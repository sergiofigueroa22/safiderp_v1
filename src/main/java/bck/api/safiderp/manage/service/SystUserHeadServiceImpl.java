package bck.api.safiderp.manage.service;

import org.springframework.stereotype.Service;
import bck.api.safiderp.core.service.GenericServiceImpl;
import bck.api.safiderp.manage.dto.SystUserHeadDTO;
import bck.api.safiderp.manage.entity.SystUserHead;
import bck.api.safiderp.manage.repository.SystUserHeadRepository;

@Service
public class SystUserHeadServiceImpl extends GenericServiceImpl<SystUserHead, Long, SystUserHeadDTO> 
implements SystUserHeadService {

	 public SystUserHeadServiceImpl(SystUserHeadRepository repository) {
	        super(repository, SystUserHead.class, SystUserHeadDTO.class);
	    }

}
