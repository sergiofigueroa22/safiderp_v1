package bck.api.safiderp.manage.entity;

import bck.api.safiderp.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "syst_user_head")
@Getter
@Setter
public class SystUserHead extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "name_syushe", length = 150)
    private String nameSyushe;

    @Column(name = "delegat_syushe", length = 150)
    private String delegateSyushe;

    @Column(name = "email_syushe", length = 150)
    @Email
    private String emailSyushe;

    @Column(name = "passwor_syushe", length = 150)
    private String passwordSyushe;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_macohe", nullable = false)
    private ManaCompHead companyHead;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_macode", nullable = false)
    private ManaCompDeta companyDeta;
}
