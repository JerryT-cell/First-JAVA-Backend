package dev.jerry.movies;

import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


//It is data access layer for our Api. It does the job of actually talking to the database and
//getting the data back
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    Optional<Movie> findMovieByImdbId(String imdbId);      //including a new method that will let us
                                                          // find the object by imdbId
                                                          //mongoDb is that intelligent to know
}
