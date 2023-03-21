package com.movie.recommend.services;

import com.movie.recommend.entities.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class MovieService {

    @Value("${movies.endpoint}")
    private String moviesEndpoint;

    private final RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Movie> getMoviesByGenre(String genre) {
        ResponseEntity<Movie[]> response = restTemplate.getForEntity(moviesEndpoint, Movie[].class);
        Movie[] movies = response.getBody();
        List<Movie> filteredMovies = new ArrayList<>();

        // Another method is using the Stream API
        for (Movie movie : movies) {
            if (movie.getGenre().equalsIgnoreCase(genre)) {
                filteredMovies.add(movie);
            }
        }
        filteredMovies.sort(Comparator.comparingInt(Movie::getReleaseYear).reversed());
        return filteredMovies;
    }
}
