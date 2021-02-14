package com.geeksHub.dev.repositories;

import com.geeksHub.dev.entities.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
    Review findByBody(String body);

}
