package com.example.mycollections.controllers;

import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    private final List<Movie> movies = new ArrayList<>() {{
        add(new Movie("1917", 2019, "Sam Mendes", 199));
        add(new Movie("500 Days of Summer", 2009, "Marc Webb", 95));
        add(new Movie("The Truman Show", 1998, "Peter Weir", 103));
    }};

    @GetMapping("json")
    private List<Movie> getMoviesJson() { return movies; }

    @GetMapping("html")
    private String getMoviesHtml() {
        String movieList = "<ul>";
        for (Movie movie : movies) {
            movieList += "<li>" + movie + "</li>";
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

}
