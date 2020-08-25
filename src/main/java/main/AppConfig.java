package main;

import com.amazonaws.auth.BasicAWSCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties(AmazonProperties.class)
public class AppConfig {

    @Autowired
    private AmazonProperties amazonProperties;

    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder()
                             .credentialsProvider(DefaultCredentialsProvider.create())
                             .endpointOverride(URI.create(amazonProperties.getDynamoUrl()))
                             .region(Region.of(amazonProperties.getRegion()))
                             .build();
    }

}
