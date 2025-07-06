package org.example.self.repository;

import org.example.self.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("db_repository")
public class DbMovieRepositoryImpl implements MovieRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Movie> rowMapper = (rs, rowNum) -> Movie.builder()
            .title(rs.getString("title"))
            .directorName(rs.getString("director_name"))
            .year(rs.getInt("year"))
            .build();

    public DbMovieRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> findAllMovies() {
        String sql = "SELECT * FROM movies;";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<Movie> findByDirector(String directorName) {
        String sql = "SELECT * FROM movies WHERE director_name=?";
        return jdbcTemplate.query(sql, rowMapper, directorName);
    }

    @Override
    public void addMovie(Movie movie) {
        String sql = "INSERT INTO movies(title, director_name, year) VALUES(?, ?, ?);";
        jdbcTemplate.update(sql, movie.getTitle(), movie.getDirectorName(), movie.getYear());
    }
}
