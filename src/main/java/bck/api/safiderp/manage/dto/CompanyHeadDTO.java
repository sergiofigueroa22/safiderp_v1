package bck.api.safiderp.manage.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyHeadDTO {
    private Long id;
    private String name;
    private String pseudonym;
    private String address;
    private String phone;
    private String delegate;
    private String webUrl;
    private String documentA;
    private String logo;
    private String documentB;
    private String documentC;
    private String alternate;
}
