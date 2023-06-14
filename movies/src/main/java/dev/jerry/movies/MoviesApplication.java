package dev.jerry.movies;

//class springApplication contains a method called run
//annotations in java are usually used to let the compiler know what the class does.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //an annotation that let the framework know that the class is a restAPI controller
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}
	/*
	Although this is a valid endpoint we are not going to make our Api like.
	we will divide our app into separate layers. There will be a service layer,
	There will be a data access layer and there will be an Api layer
	 */

}
