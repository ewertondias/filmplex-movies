package com.filmplex.movies.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public abstract class Movie {

    private Double popularity;

    @JsonProperty(value = "vote_count")
    private Integer voteCount;

    private Boolean video;

    @JsonProperty(value = "poster_path")
    private String posterPath;

    @EqualsAndHashCode.Include
    private Long id;

    private Boolean adult;

    @JsonProperty(value = "backdrop_path")
    private String backdropPath;

    @JsonProperty(value = "original_language")
    private String originalLanguage;

    @JsonProperty(value = "original_title")
    private String originalTitle;

    private String title;

    @JsonProperty(value = "vote_average")
    private Double voteAverage;

    private String overview;

    @JsonProperty(value = "release_date")
    private Date releaseDate;

}
