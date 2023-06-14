package dev.jerry.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews") //we have not created this collection yet but the application
                                  //will create it for us
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    private Object id;
    private String body;

    public Review(final String body) {
        this.body = body;
    }
}
