package in.brainupgrade.dynamodb;


import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface UserRepository extends CrudRepository<User, UserKey> {
	List<User> findByLastName(String lastName);
	List<User> findAll();
}