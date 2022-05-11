package in.brainupgrade.dynamodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository repository;
	@Autowired
	AmazonDynamoDB amazonDynamoDB;

	public void sampleTestCase() {
		User gosling = new User("James", "Gosling");
		repository.save(gosling);

		User hoeller = new User("Juergen", "Hoeller");
		repository.save(hoeller);

		List<User> result = repository.findByLastName("Gosling");
		log.info("found users: " + result);

	}
}
