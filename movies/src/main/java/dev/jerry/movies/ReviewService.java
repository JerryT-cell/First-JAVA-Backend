package dev.jerry.movies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service // for classes that provide some functionalities
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

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
       reviewRepository.insert(review);
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewsId").value(review));

    return review;
    }
}
