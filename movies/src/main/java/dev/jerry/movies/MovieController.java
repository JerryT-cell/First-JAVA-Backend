package dev.jerry.movies;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//In rest Api there are multiple layers .
//one is the Api layer : which is this controller
//It is this controller. It gets requests from the user and returning a response and noting else.
// It uses a service class and delegating the task of fetching all the movies from the database and
// giving it back to the api layer. It calls the allmovies method in the Movieservice ,
// gets the list of the movie and returns them with httpstatus 200.
// It doesn't know what’s going on in the service class.

@RestController
//instead of mapping it to localhost:8080 we will map it to :
@RequestMapping("/api/v1/movies")  //any request to /api/v1/movies will be handled by this
// controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * getting all the movies and return it
     * @return all movies
     */
    @GetMapping
    public ResponseEntity<List<Movie>> allMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }
    //Http.Status will return a 200 response. Any proper rest Api should return a proper status code
    //since we have the movie model, we will pull some data from the database.

    @GetMapping("/{imdbId}")
    //path variable : passing the information we get from the mapping as path variable
    //What ever we are getting through the path variable, we want to convert that to an object Id
    // called id
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
            return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId),HttpStatus.OK);
    }
}
