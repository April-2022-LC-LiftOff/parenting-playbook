package org.launchcode.liftoffproject.data;


import org.launchcode.liftoffproject.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
