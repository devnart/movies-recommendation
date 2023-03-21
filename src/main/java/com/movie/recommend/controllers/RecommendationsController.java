package com.movie.recommend.controllers;

import com.movie.recommend.entities.Movie;
import com.movie.recommend.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommendationsController {
    private final MovieService movieService;

    public RecommendationsController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/recommendations")
    public List<Movie> getRecommendationsByGenre(@RequestParam String genre) {
        return movieService.getMoviesByGenre(genre);
    }
}
