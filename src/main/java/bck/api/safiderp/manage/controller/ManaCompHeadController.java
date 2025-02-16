package bck.api.safiderp.manage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bck.api.safiderp.core.controller.GenericController;
import bck.api.safiderp.manage.dto.CompanyHeadDTO;
import bck.api.safiderp.manage.service.ManaCompHeadService;

@RestController
@RequestMapping("/api/company-heads")
public class ManaCompHeadController extends GenericController<CompanyHeadDTO, Long> {

    public ManaCompHeadController(ManaCompHeadService service) {
    	super(service); 
    }
}
