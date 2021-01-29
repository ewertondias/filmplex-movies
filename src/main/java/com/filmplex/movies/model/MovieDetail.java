package com.filmplex.movies.model;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class MovieDetail extends Movie {

    private Double budget;
    private List<MovieGenre> genres;
    private MovieVideo videos;

}
