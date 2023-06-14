package dev.jerry.movies;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//uses the movieRepository to talk to the database.
//for e.g, uses the allmovies method to get all the movies and returns to the api layer(controller)
public class MovieService {
    @Autowired//instantiate this class for us
    private  MovieRepository movieRepository;
//we write the database access method
    public List<Movie> allMovies(){
        return movieRepository.findAll();

    }

    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
