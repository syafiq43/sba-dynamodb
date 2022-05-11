package in.brainupgrade.dynamodb;



import java.util.Date;

import org.springframework.data.annotation.Id;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;

@DynamoDBTable(tableName = "UserAccess")
@Data
@NoArgsConstructor
public class User {

	@Id
	@DynamoDBHashKey
	private String email;
	@DynamoDBAttribute
	private Date accessTime;
	@DynamoDBAttribute
	private String firstName;
	@DynamoDBAttribute
	private String lastName;
	@DynamoDBAttribute
	private String urlAccessed;

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}