package com.prestoncoldwell.JavaProject;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReviewRepository extends MongoRepository<Review, UUID> {
}
