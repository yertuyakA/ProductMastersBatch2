package org.example.self.repository;

import org.example.self.model.Movie;

import java.util.List;

public interface MovieRepository {

    List<Movie> findAllMovies();

    List<Movie> findByDirector(String directorName);

    void addMovie(Movie movie);
}