package org.example.self.repository;

import org.example.self.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository("local_repository")
public class LocalMemoryMovieRepositoryImpl implements MovieRepository {

    private final List<Movie> movies = new ArrayList<>(Arrays.asList(
            new Movie("Inception", "Christopher Nolan", 2010),
            new Movie("The Godfather", "Francis Ford Coppola", 1972),
            new Movie("Pulp Fiction", "Quentin Tarantino", 1994)
    ));

    @Override
    public List<Movie> findAllMovies() {
        return movies;
    }

    @Override
    public List<Movie> findByDirector(String directorName) {
        return movies.stream().filter(m -> directorName.equals(m.getDirectorName())).toList();
    }

    @Override
    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}
