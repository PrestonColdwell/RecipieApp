package com.prestoncoldwell.JavaProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String recipeId) {
        Review review = new Review(reviewBody);
        review.setRecipeId(UUID.fromString(recipeId));
        // Set other fields as needed, e.g., userId, rating

        reviewRepository.insert(review);

        mongoTemplate.update(Recipe.class)
                .matching(Criteria.where("id").is(recipeId))
                .apply(new Update().push("reviewIds").value(review.getId()))
                .first();

        return review;
    }

    public Review getReviewById(UUID reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    public List<Review> getReviewsByRecipeId(UUID recipeId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("recipeId").is(recipeId));
        return mongoTemplate.find(query, Review.class);
    }
}