package com.example.mycollections.controllers;

import com.example.mycollections.data.MovieData;
import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("movies")
public class MovieController {

    /*Don't need this here with a data layer*/
//    private final List<Movie> movies = new ArrayList<>() {{
//        add(new Movie("1917", 2019, "Sam Mendes", 199));
//        add(new Movie("500 Days of Summer", 2009, "Marc Webb", 95));
//        add(new Movie("The Truman Show", 1998, "Peter Weir", 103));
//    }};

    @GetMapping("json")
    private Collection<Movie> getMoviesJson() { return MovieData.getAll(); }

    @GetMapping("html")
    private String getMoviesHtml() {
        String movieList = "<ul>";
        for (Movie movie : MovieData.getAll()) {
            movieList +=    "<li>" + movie.getId() + ": " + movie.getName() +
                                "<ul>" +
                                    "<li> Year: " + movie.getYear() + "</li>" +
                                    "<li> Director: " + movie.getDirector() + "</li>" +
                                    "<li> Runtime: " + movie.getRuntime() + "</li>" +
                                "</ul>" +
                            "</li>";
        }
        movieList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Movies</h1>
                        <ul>
                """ +
                movieList +
                """
                        </ul>
                    </body>
                """;

    }

    /*Lives at http://localhost:8080/movies/{id}, where {id} is a path variable we can use to get the right record.*/
    @GetMapping("/{id}")
    private String getSingleMovieAsString(@PathVariable int id /*variable name MUST be the same as what is in your path*/) {
        /*Without data layer. Optional is a class we will probably encounter later. Java likes to be sure the object you're
         requesting actually exists, and Optional is one way to do that. As you can see below with the data layer,
         it's more lenient with letting it slip by - this is where error handling is very important! You'll notice that if
         you test the endpoint with an id that doesn't exist (using data layer solution), you'll get a 500 error.*/
//        Optional<Movie> optMovie = Optional.empty();
//
//        for (Movie movie: movies) {
//            if (movie.getId() == id) {
//                optMovie = Optional.of(movie);
//            }
//        }
//
//        if (optMovie.isEmpty()) {
//            return "No movie by that ID!";
//        }
//
//        Movie selectedMovie = optMovie.get();
//        return selectedMovie.toString();

        //With data layer
        return MovieData.getById(id).toString();
    }

    /*name, year, director, and runtime are all @RequestParams sent through the URL to your handler*/
    @PostMapping("/add")
    public String addNewMovie(@RequestParam String name, int year, String director, int runtime) {
        Movie newMovie = new Movie(name, year, director, runtime);
        //Without data layer
        //movies.add(newMovie);

        //With data layer
        MovieData.addNew(newMovie);

        return "Movie added: \n" + newMovie;
    }

    /*If sending a raw JSON object, in Postman select Body -> Raw -> JSON. Format looks like this:
        {
        "name": "fjsfngkjnsg",
        "year": 1985,
        "director": "unknown",
        "runtime": 120
        }
        This whole object is then sent in the post request as a @RequestBody
     */
    @PostMapping("/add/rawJSON")
    public String addNewMovie(@RequestBody Movie movie) {
        Movie newMovie = new Movie(movie.getName(), movie.getYear(), movie.getDirector(), movie.getRuntime());
        //Without data layer
        //movies.add(newMovie);

        //With data layer
        MovieData.addNew(newMovie);

        return "Movie added: \n" + newMovie;
    }
}
