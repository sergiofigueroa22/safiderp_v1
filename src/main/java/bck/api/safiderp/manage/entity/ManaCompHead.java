package bck.api.safiderp.manage.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import bck.api.safiderp.core.entity.BaseEntity;

import java.util.Set;

@Entity
@Table(name = "mana_comp_head")
@Getter
@Setter
public class ManaCompHead extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name_macohe", nullable = false, length = 300)
    private String name;

    @Column(name = "pseudon_macohe", length = 250)
    private String pseudonym;

    @Column(name = "address_macode", length = 250)
    private String address;

    @Column(name = "phone_macode", length = 15)
    private String phone;

    @Column(name = "delegat_macohe", length = 150)
    private String delegate;

    @Column(name = "url_web_macohe", length = 60)
    private String webUrl;

    @Column(name = "documea_macohe", nullable = false, length = 20)
    private String documentA;

    @Column(name = "logo_macohe", length = 60)
    private String logo;

    @Column(name = "documeb_macohe", length = 20)
    private String documentB;

    @Column(name = "documec_macohe", length = 20)
    private String documentC;

    @Column(name = "alterna_macohe", length = 3)
    private String alternate;

    @OneToMany(mappedBy = "companyHead", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ManaCompDeta> companyDetails;
}
