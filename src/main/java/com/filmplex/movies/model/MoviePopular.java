package com.filmplex.movies.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class MoviePopular extends Movie {

    @JsonProperty(value = "genre_ids")
    private List<Integer> genreIds;

}
