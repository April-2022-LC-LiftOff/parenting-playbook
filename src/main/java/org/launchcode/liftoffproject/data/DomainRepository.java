package org.launchcode.liftoffproject.data;

import org.launchcode.liftoffproject.models.Domain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends CrudRepository<Domain, Integer> {
}
