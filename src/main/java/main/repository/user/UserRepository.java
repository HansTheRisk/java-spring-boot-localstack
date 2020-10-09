package main.repository.user;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;

@Repository
public class UserRepository {

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    public User getUser(String username) {
        GetItemRequest request = new GetItemRequest().withTableName("user")
                                                     .withConsistentRead(true)
                                                     .withKey(Collections.singletonMap("username", new AttributeValue(username)));
        GetItemResult result = amazonDynamoDB.getItem(request);
        return new UserMapper().mapToDomain(result);
    }
}
