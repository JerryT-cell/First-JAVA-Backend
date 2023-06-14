package dev.jerry.movies;
//now we want a review controller

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository 
        //repositories 
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
