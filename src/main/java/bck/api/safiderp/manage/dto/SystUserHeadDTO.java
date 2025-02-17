package bck.api.safiderp.manage.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SystUserHeadDTO {
	private Integer id;
    private String nameSyushe;
    private String delegateSyushe;
    private String emailSyushe;
    private String passwordSyushe;
    private Long companyHeadId;
    private Long companyDetaId;   
}
