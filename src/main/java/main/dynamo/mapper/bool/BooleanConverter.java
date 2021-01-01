package main.dynamo.mapper.bool;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

/**
 * A quasi-experimental dynamodb boolean converter.
 * Replaced by using the {@link com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped}
 */

@Deprecated
public class BooleanConverter implements DynamoDBTypeConverter<String, Boolean> {
    @Override
    public String convert(Boolean object) {
        return object.toString();
    }

    @Override
    public Boolean unconvert(String object) {
        return Boolean.valueOf(object);
    }
}
