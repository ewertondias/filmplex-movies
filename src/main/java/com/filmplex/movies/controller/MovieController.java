package com.filmplex.movies.controller;

import com.filmplex.movies.exception.MovieNotFoundException;
import com.filmplex.movies.model.MovieDetail;
import com.filmplex.movies.model.MovieResult;
import com.filmplex.movies.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<MovieResult> list(@RequestParam(required = false, defaultValue = "1") final Integer page) {
        return ResponseEntity.ok(movieService.list(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDetail> findById(@PathVariable final Long id) {
        try {
            return ResponseEntity.ok(movieService.findById(id));
        } catch (MovieNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
