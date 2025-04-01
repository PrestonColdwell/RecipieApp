package com.prestoncoldwell.JavaProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.Instant;
import java.util.UUID;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @Field(targetType = FieldType.STRING)
    private UUID id;

    private UUID recipeId;
    private String userId;
    private Double rating;
    private String comment;
    private Instant createdAt;

    // Constructor to match the parameters passed in the service
    public Review(String reviewBody) {
        this.id = UUID.randomUUID();
        this.comment = reviewBody;
        this.createdAt = Instant.now();
    }
}