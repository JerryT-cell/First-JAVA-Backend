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

//REST API LAYERS :  
//* Controller
// I use  service classes and delegate the task of fetching all the movies from the database.
// gets the list of the movie and returns them with httpstatus 200.

@RestController
@RequestMapping("/api/v1/movies")  
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

    @GetMapping("/{imdbId}")
 
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
            return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId),HttpStatus.OK);
    }
}
