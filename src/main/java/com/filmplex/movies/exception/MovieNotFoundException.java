package com.filmplex.movies.exception;

public class MovieNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5125980145843602700L;

    public MovieNotFoundException(String message) {
        super(message);
    }
}
