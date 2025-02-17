package bck.api.safiderp.manage.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CompanyDetailDTO {
    private Long id;
    private String name;
    private String pseudonym;
    private String address;
    private String phone;
    private String email;
    private String delegate;
    private String documentA;
    private String documentB;
    private String documentC;
    private String alternate;
    private Long companyHeadId; 
}
