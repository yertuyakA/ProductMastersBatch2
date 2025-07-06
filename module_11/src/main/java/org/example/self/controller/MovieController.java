package org.example.self.controller;

import jakarta.validation.Valid;
import org.example.self.model.Movie;
import org.example.self.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/movies")
@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public List<Movie> getAllMoviesInJson() {
        return movieService.getAllMovies();
    }

    @GetMapping("/by-director")
    public List<Movie> getAllMoviesByDirector(@RequestParam(name = "director") String name) {
        return movieService.getMoviesByDirector(name);
    }

    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie(@RequestBody @Valid Movie movie) {
        movieService.addMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }
}
