package org.example.hw.repository;

import org.example.hw.model.Movie;

import java.util.List;

public interface MovieRepository {

    List<Movie> findAllMovies();

    List<Movie> findByDirector(String directorName);

    void addMovie(Movie movie);
}
