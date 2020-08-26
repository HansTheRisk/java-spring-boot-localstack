package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
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
        AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(amazonProperties.getAccessKey(),
                                                                        amazonProperties.getSecretKey());
        return DynamoDbClient.builder()
                             .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
                             .endpointOverride(URI.create(amazonProperties.getDynamoUrl()))
                             .region(Region.of(amazonProperties.getRegion()))
                             .build();
    }

}
