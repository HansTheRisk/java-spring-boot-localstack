package main;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(AmazonDynamoDB client) {
        return args -> System.out.println(client.listTables());
    }
}
