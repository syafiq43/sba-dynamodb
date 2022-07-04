package in.brainupgrade.sqs;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import in.brainupgrade.dynamodb.User;
import in.brainupgrade.dynamodb.UserService;
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Consumer {

//    @Value("${cloud.aws.end-point.uri}")
//    private String endpoint;
	@Autowired
	UserService userService;
    
    @SqsListener(value = "${cloud.aws.end-point.uri-usage}",deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void processMessage(AppUsageRecord usage) {
        log.info("App Usage Record Message from SQS {}", usage.getUrlAccessed());
        //save this user access log into dynamo db using userService
		User user = new User();
		user.setEmail(usage.getEmail());
		user.setFirstName(usage.getFirstName());
		user.setLastName(usage.getLastName());
		user.setAccessTime(usage.getAccessTime());
		user.setUrlAccessed(usage.getUrlAccessed());
		userService.saveAccessLog(user);
    }
}