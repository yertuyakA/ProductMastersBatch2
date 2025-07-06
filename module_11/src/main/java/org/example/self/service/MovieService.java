package org.example.self.service;

import org.example.self.repository.MovieRepository;
import org.example.self.model.Movie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(@Qualifier("db_repository") MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAllMovies();
    }

    public List<Movie> getMoviesByDirector(String directorName) {
        return movieRepository.findByDirector(directorName);
    }

    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }
}
