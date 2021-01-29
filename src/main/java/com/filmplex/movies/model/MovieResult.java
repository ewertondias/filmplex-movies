package com.filmplex.movies.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class MovieResult {

    private Integer page;

    @JsonProperty(value = "total_results")
    private Integer totalResults;

    @JsonProperty(value = "total_pages")
    private Integer totalPages;

    @JsonProperty(value = "results")
    private List<MoviePopular> movies;

}
