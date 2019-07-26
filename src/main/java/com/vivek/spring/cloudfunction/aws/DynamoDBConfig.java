package com.vivek.spring.cloudfunction.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The DynamoDB Config Class.
 * Here we have 2 ways of connecting .
 * One is using access key and secret access key. This is good for local testing.
 * The other one is using role based authentication. LambdaRole  will be given permission to access this Tables.
 */
@Configuration
@EnableDynamoDBRepositories(basePackages = "com.vivek.spring.cloudfunction.aws.repo")
public class DynamoDBConfig {

    @Value("${amazon.dynamodb.endpoint}") private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey}") private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}") private String amazonAWSSecretKey;

    @Bean public AmazonDynamoDB amazonDynamoDB(){
        String checkEnv = System.getenv("CHECK_ENV");
        if (null != checkEnv && ("LOCAL").equalsIgnoreCase(checkEnv)) {
            return AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
                new AwsClientBuilder.EndpointConfiguration(amazonDynamoDBEndpoint, "us-east-1")).build();

        } else {
            return AmazonDynamoDBClientBuilder.standard().withRegion(Regions.EU_WEST_1).build();
        }
    }

    @Bean public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }

}
