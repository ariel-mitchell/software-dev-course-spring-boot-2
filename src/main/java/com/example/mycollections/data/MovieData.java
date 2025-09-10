package com.example.mycollections.data;

import com.example.mycollections.models.Movie;

import java.util.*;

public class MovieData {
    /* Temporary representation of database */

    // Will be replaced by a JPA Repository in Part 2
    // Each Movie object is stored by its ID in a HashMap
    private static final Map<Integer, Movie> movies = new HashMap<>();

    /* Temporary methods for CRUD operations */

    // Will be replaced by JPA Repository method .findAll()
    public static Collection<Movie> getAll() {
        return movies.values();
    }

    // Will be replaced by JPA Repository method .save()
    public static void addNew(Movie movie) {
        movies.put(movie.getId(), movie);
    }

    // Will be replaced by JPA Repository method .findById()
    public static Movie getById(int id) {
        return movies.get(id);
    }
}
