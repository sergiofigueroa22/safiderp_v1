package bck.api.safiderp.manage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bck.api.safiderp.core.controller.GenericController;
import bck.api.safiderp.manage.dto.SystUserHeadDTO;
import bck.api.safiderp.manage.service.SystUserHeadService;

@RestController
@RequestMapping("/api/user-heads")
public class SystUserHeadController extends GenericController<SystUserHeadDTO, Long> {

	public SystUserHeadController(SystUserHeadService service) {
		super(service);
	}

}
