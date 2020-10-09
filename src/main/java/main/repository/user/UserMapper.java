package main.repository.user;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;

import java.util.Map;
import java.util.stream.Collectors;

public class UserMapper {

    public final String ID = "id";
    public final String USERNAME = "username";
    public final String PASSWORD = "password";
    public final String ACCOUNT_EXPIRED = "accountExpired";
    public final String LOCKED = "locked";
    public final String PASSWORD_EXPIRED = "passwordExpired";
    public final String ENABLED = "enabled";
    public final String AUTHORITIES = "authorities";

    public User mapToDomain(GetItemResult result) {
        Map<String, AttributeValue> attributes = result.getItem();
        return new User(attributes.get(ID).getS(),
                        attributes.get(USERNAME).getS(),
                        attributes.get(PASSWORD).getS(),
                        attributes.get(ACCOUNT_EXPIRED).getBOOL(),
                        attributes.get(LOCKED).getBOOL(),
                        attributes.get(PASSWORD_EXPIRED).getBOOL(),
                        attributes.get(ENABLED).getBOOL(),
                        attributes.get(AUTHORITIES).getSS().stream()
                                                           .map(a -> new User.Authority(a))
                                                           .collect(Collectors.toSet()));
    }

}
