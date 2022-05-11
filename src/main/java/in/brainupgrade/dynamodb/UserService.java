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

	public void saveAccessLog(User user) {
		repository.save(user);
	}
	public List<User> getUserLogs(String lastName){
		List<User> result = repository.findByLastName(lastName);
		log.info("found user logs: " + result);
		return result;
	}
}
