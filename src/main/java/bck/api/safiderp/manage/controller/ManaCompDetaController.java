package bck.api.safiderp.manage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bck.api.safiderp.core.controller.GenericController;
import bck.api.safiderp.manage.dto.CompanyDetailDTO;
import bck.api.safiderp.manage.service.ManaCompDetaService;

@RestController
@RequestMapping("/api/company-details")
public class ManaCompDetaController extends GenericController<CompanyDetailDTO, Long> {

    public ManaCompDetaController(ManaCompDetaService service) {
        super(service); 
    }
}
