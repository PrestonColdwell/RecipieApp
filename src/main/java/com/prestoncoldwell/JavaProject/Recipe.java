package com.prestoncoldwell.JavaProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
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

    private List<UUID> reviewIds;

    private Instant createdAt;
    private Instant updatedAt;

    // Additional fields
    private String difficultyLevel;
    private Number servings;
    private NutritionInfo nutritionInfo;
    private String cuisine;
    private String author;
    private String videoUrl;
    private String notes;
    private Number estimatedCost;
    private Double rating;
}