package org.example.hw.service;

import org.example.hw.model.Movie;
import org.example.hw.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
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
