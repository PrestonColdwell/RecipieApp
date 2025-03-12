package com.prestoncoldwell.JavaProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Document(collection = "recipes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    @Field(targetType = FieldType.STRING)
    private UUID id;

    private String name;
    private String description;
    private List<String> images;
    private Number prepTime;
    private Number cookTime;
    private List<Ingredient> ingredients;
    private List<String> steps;
    private List<String> tags;
    private String userId;

    @DocumentReference
    private List<Review> reviewIds;

    private Instant createdAt;
    private Instant updatedAt;
}