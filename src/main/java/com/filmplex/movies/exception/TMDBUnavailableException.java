package com.filmplex.movies.exception;

public class TMDBUnavailableException extends RuntimeException {

    private static final long serialVersionUID = 5125980145843602700L;

    public TMDBUnavailableException(String message) {
        super(message);
    }
}
