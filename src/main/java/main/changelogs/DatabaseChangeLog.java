package main.changelogs;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import com.github.dynamobee.changeset.ChangeLog;
import com.github.dynamobee.changeset.ChangeSet;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", author = "dynamobee", id = "user")
    public void users(AmazonDynamoDB amazonDynamoDB) {
        Collection<KeySchemaElement> elements = Arrays.asList(new KeySchemaElement("id", KeyType.HASH));

        CreateTableRequest request = new CreateTableRequest().withTableName("user")
                                                             .withKeySchema(elements)
                                                             .withAttributeDefinitions(new AttributeDefinition("id", "S"),
                                                                                       new AttributeDefinition("username", "S"),
                                                                                       new AttributeDefinition("password", "S"),
//                                                                                       new AttributeDefinition("accountExpired", "BOOL"),
//                                                                                       new AttributeDefinition("locked", "BOOL"),
//                                                                                       new AttributeDefinition("passwordExpired", "BOOL"),
//                                                                                       new AttributeDefinition("enabled", "BOOL"),
                                                                                       new AttributeDefinition("authorities", "SS"))
                .withBillingMode(BillingMode.PAY_PER_REQUEST)
                .withProvisionedThroughput(new ProvisionedThroughput(500L, 500L));
        amazonDynamoDB.createTable(request);
    }

    @ChangeSet(order = "002", author = "dynamobee", id = "admin_populate")
    public void adminPopulate(AmazonDynamoDB amazonDynamoDB) {
        Map<String, AttributeValue> request = Map.of("id", new AttributeValue(UUID.randomUUID().toString()),
                                                     "username", new AttributeValue("admin"),
                                                     "password", new AttributeValue("admin"),
//                                                     "accountExpired", new AttributeValue("false"),
//                                                     "locked", new AttributeValue("false"),
//                                                     "passwordExpired", new AttributeValue("false"),
//                                                     "enabled", new AttributeValue("true"),
                                                     "authorities", new AttributeValue("[\"ADMIN\", \"USER\"]"));

        amazonDynamoDB.putItem(new PutItemRequest("user", request));
    }

}
