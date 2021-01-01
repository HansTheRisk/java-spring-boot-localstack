package main.dynamo.annotation.bool;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import main.dynamo.mapper.bool.BooleanConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A deprecated annotation for handling the boolean type by dynamodb using a custom converter.
 * See {@link BooleanConverter}
 * Replaced by {@link com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped}
 */
@Deprecated
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@DynamoDB
@DynamoDBTypeConverted(converter = BooleanConverter.class)
public @interface DynamoDBBooleanAttribute {
}
