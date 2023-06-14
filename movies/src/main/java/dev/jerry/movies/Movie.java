 package dev.jerry.movies;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "movies") //this class presents each document in the movie collection
@Data  //Instead of writing getters and setters we can use this annotation which
       //comes from the lombok dependency. It takes care of all those getters, setters and
       // toString methods
@AllArgsConstructor //annotation for creating a constructor that takes all the private fields
                    //as argument
@NoArgsConstructor  // another constructor that takes no parameter
public class Movie {
    @Id //unique identifier for each movie in the database
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference //will cause the db to save only the id of the review and the reviews will be
                       //on a separate collection.
    private List<Review> reviewIds; //embedded relationship. All the review related to this movie
                                    //will be added to this list

}
