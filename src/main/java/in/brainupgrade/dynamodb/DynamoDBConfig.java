package in.brainupgrade.dynamodb;


import org.socialsignin.spring.data.dynamodb.mapping.DynamoDBMappingContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

@Configuration
public class DynamoDBConfig {

	@Value("${cloud.aws.region.static}")
	private String region;
	@Value("${cloud.aws.credentials.access-key}")
	private String amazonAWSAccessKey;

	@Value("${cloud.aws.credentials.secret-key}")
	private String amazonAWSSecretKey;

	public AWSCredentialsProvider amazonAWSCredentialsProvider() {
		return new AWSStaticCredentialsProvider(amazonAWSCredentials());
	}

	@Bean
	public AWSCredentials amazonAWSCredentials() {
		return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
	}

//	@Bean
//	public DynamoDBMapperConfig dynamoDBMapperConfig() {
//		return DynamoDBMapperConfig.DEFAULT;
//	}

//	@Bean
//	public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig config) {
//		return new DynamoDBMapper(amazonDynamoDB, config);
//	}

	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		return AmazonDynamoDBClientBuilder.standard().withCredentials(amazonAWSCredentialsProvider())
				.withRegion(Regions.AP_SOUTH_1).build();
	}

//	@Bean
//	@Profile("rest")
//	public DynamoDBMappingContext dynamoDBMappingContext() {
//		return new DynamoDBMappingContext();
//	}

	
}