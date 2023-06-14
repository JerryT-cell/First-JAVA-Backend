package dev.jerry.movies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service // for classes that provide some business functionalities
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;


    //you know repositories as one way to store data. Now you have a template
    //you can use a template to form a new dynamic query(from the database) without using the repository
    //you can basically perform more operations
    private MongoTemplate mongoTemplate;

    /**
     * first look for the movie with the given imdbId, then we create a new review and assciate it
     * to that movie
     * @param reviewBody review
     * @param imdbId imbdbid of the movie
     * @return a review
     */
    public Review createReview(String reviewBody, String imdbId) {
       Review review = new Review(reviewBody);
       //we have to insert it to the database.
       reviewRepository.insert(review);
       //we have to associate with the movie.
        //we use a template to perform an update in that movie
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewsId").value(review));

    return review;
    }
}
