package org.launchcode.liftoffproject.data;

import org.launchcode.liftoffproject.models.Intervention;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterventionRepository extends CrudRepository<Intervention, Integer> {
}
