package in.brainupgrade;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import in.brainupgrade.dynamodb.DynamoDBConfig;
import in.brainupgrade.dynamodb.UserRepository;


@SpringBootApplication
@EnableScheduling
@Import(DynamoDBConfig.class)
@EnableDynamoDBRepositories(basePackageClasses = UserRepository.class)
public class SBADynamoDBApplication  {
	
	public static void main(String[] args) {
		SpringApplication.run(SBADynamoDBApplication.class, args);
	}


}
