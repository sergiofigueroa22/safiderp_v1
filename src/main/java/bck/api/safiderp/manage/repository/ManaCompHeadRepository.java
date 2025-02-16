package bck.api.safiderp.manage.repository;

import org.springframework.stereotype.Repository;

import bck.api.safiderp.core.repository.GenericRepository;
import bck.api.safiderp.manage.entity.ManaCompHead;

@Repository
public interface ManaCompHeadRepository extends GenericRepository<ManaCompHead, Long> {
}
