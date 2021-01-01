package main.repository.user;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;

/**
 * This is a deprecated class kept as an example of alternatives to extending the CrudRepository interface.
 *
 * The first method shows how to search for dynamodb documents using the AmazonDynamoDb object.
 * The second method shows the same, but with the use of the DynamoDbMapper object.
 *
 * For a CRUD interface implementation see {@link UserRepository}
 */
@Deprecated()
@Repository
public class UserRepository_Old {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Deprecated
    public User getUser_Old(String username) {
        GetItemRequest request = new GetItemRequest().withTableName("user")
                                                     .withConsistentRead(true)
                                                     .withKey(Collections.singletonMap("username", new AttributeValue(username)));
        GetItemResult result = amazonDynamoDB.getItem(request);
        return new UserMapper().mapToDomain(result);
    }

    @Deprecated
    public User getUser(String username) {
        return dynamoDBMapper.load(User.class, username);
    }
}
