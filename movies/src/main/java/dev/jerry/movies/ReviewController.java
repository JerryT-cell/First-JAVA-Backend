package dev.jerry.movies;


import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")

//this is a new rest Api endpoint
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    //what ever we get as a request body, we would like to convert as a map of string
    //Simply put, the @RequestBody annotation maps the HttpRequest body to a transfer or
    // domain object, enabling automatic deserialization of the inbound HttpRequest body
    // onto a Java object

    //what will happen here is that this endpoint will receive a json data from the user and will
    //convert it to a map where the keys are in string and the value are in string.
    //from this map we will be able to access the review
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(
                reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")),
                HttpStatus.CREATED);
    }


}
