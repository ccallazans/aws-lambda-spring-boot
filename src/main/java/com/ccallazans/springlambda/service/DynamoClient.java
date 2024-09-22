package com.ccallazans.springlambda.service;


import com.ccallazans.springlambda.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DynamoClient {

    private final DynamoDbClient dynamoDbClient;

    public void saveUser(User user) {
        var item = Map.of(
                "uuid", AttributeValue.builder().s(user.getUuid().toString()).build(),
                "email", AttributeValue.builder().s(user.getEmail()).build(),
                "created_at", AttributeValue.builder().s(user.getCreatedAt().toString()).build()
        );

        var request = PutItemRequest.builder()
                .tableName(System.getenv("DYNAMODB_TABLE"))
                .item(item)
                .build();

        dynamoDbClient.putItem(request);
    }

    public List<User> getAllUsers() {
        var request = ScanRequest.builder()
                .tableName(System.getenv("DYNAMODB_TABLE"))
                .build();

        var response = dynamoDbClient.scan(request);

        return response.items().stream()
                .map(item -> new User(
                        UUID.fromString(item.get("uuid").s()),
                        item.get("email").s(),
                        LocalDateTime.parse(item.get("created_at").s()))
                ).collect(Collectors.toList());
    }
}
