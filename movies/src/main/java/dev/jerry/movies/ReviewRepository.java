package dev.jerry.movies;
//now we want a review controller

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository //indicate that the class provides the mechanism for storage, retrieval,search, update
            //and delete operation on objects
        //repositories are a way to talk to the database
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
