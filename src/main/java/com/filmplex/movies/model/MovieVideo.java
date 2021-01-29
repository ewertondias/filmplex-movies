package com.filmplex.movies.model;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class MovieVideo {

    private List<MovieVideoResult> results;

}
