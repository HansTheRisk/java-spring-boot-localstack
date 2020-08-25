package main;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
@EnableAutoConfiguration
public class AppConfig {

    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.create();
    }

}
