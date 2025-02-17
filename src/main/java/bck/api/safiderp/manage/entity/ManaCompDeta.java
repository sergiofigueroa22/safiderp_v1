package bck.api.safiderp.manage.entity;

import lombok.Getter;
import lombok.Setter;
import bck.api.safiderp.core.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "mana_comp_deta")
@Getter
@Setter
public class ManaCompDeta extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "name_macode", nullable = false, length = 300)
	@NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Column(name = "pseudon_macode", length = 250)
    private String pseudonym;

    @Column(name = "address_macode", length = 250)
    private String address;

    @Column(name = "phone_macode", length = 15)
    private String phone;
    
    @Column(name = "email_macode", length = 150)
    @Email
    private String email;

    @Column(name = "delegat_macode", length = 150)
    private String delegate;

    @Column(name = "documea_macode", length = 20)
    private String documentA;

    @Column(name = "documeb_macode", length = 20)
    private String documentB;

    @Column(name = "documec_macode", length = 20)
    private String documentC;

    @Column(name = "alterna_macode", length = 3)
    private String alternate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_macohe", nullable = false)
    private ManaCompHead companyHead;
}