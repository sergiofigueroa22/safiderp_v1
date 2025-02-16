package bck.api.safiderp.manage.service;
import bck.api.safiderp.core.service.GenericServiceImpl;
import bck.api.safiderp.manage.dto.CompanyDetailDTO;
import bck.api.safiderp.manage.entity.ManaCompDeta;
import bck.api.safiderp.manage.repository.ManaCompDetaRepository;
import org.springframework.stereotype.Service;

@Service
public class ManaCompDetaServiceImpl extends GenericServiceImpl<ManaCompDeta, Long, CompanyDetailDTO> implements ManaCompDetaService {

    public ManaCompDetaServiceImpl(ManaCompDetaRepository repository) {
        super(repository, ManaCompDeta.class, CompanyDetailDTO.class); 
    }
}