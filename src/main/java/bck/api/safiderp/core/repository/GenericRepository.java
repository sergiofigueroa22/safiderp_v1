package bck.api.safiderp.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import bck.api.safiderp.core.entity.BaseEntity;

@NoRepositoryBean
public interface GenericRepository<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {
}
