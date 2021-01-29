package com.filmplex.movies.service;

import com.filmplex.movies.config.TMDBConfig;
import com.filmplex.movies.exception.MovieNotFoundException;
import com.filmplex.movies.exception.TMDBUnavailableException;
import com.filmplex.movies.model.MovieDetail;
import com.filmplex.movies.model.MovieResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MovieService {

    private final TMDBConfig TMDBConfig;

    public MovieService(TMDBConfig TMDBConfig) {
        this.TMDBConfig = TMDBConfig;
    }

    public MovieResult list(final Integer page) {
        MovieResult movieResult;
        try {
            // TODO: Extrair
            UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme(TMDBConfig.getUrl().get("protocol"))
                .host(TMDBConfig.getUrl().get("host"))
                .path("{version}/{path}")
                .query("api_key={api-key}")
                .query("language={language}")
                .query("page={page}")
                .buildAndExpand(
                    TMDBConfig.getUrl().get("version"),
                    TMDBConfig.getUrl().get("path"),
                    TMDBConfig.getApiKey(),
                    TMDBConfig.getUrl().get("language"),
                    page
                );

            RestTemplate restTemplate = new RestTemplate();
            movieResult = restTemplate.getForObject(uri.toString(), MovieResult.class);
        } catch (Exception e) {
            throw new TMDBUnavailableException("Erro ao acessar API TMDB");
        }

        return movieResult;
    }

    public MovieDetail findById(Long id) {
        MovieDetail movie;
        try {
            // TODO: Extrair
            UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme(TMDBConfig.getUrl().get("protocol"))
                .host(TMDBConfig.getUrl().get("host"))
                .path("{version}/{path}")
                .query("api_key={api-key}")
                .query("language={language}")
                .query("append_to_response=videos") // TODO: Deixar como parametro
                .buildAndExpand(
                    TMDBConfig.getUrl().get("version"),
                    "movie/" + id, // TODO: Refatorar
                    TMDBConfig.getApiKey(),
                    TMDBConfig.getUrl().get("language")
                );

            RestTemplate restTemplate = new RestTemplate();
            movie = restTemplate.getForObject(uri.toString(), MovieDetail.class);
        } catch (Exception e) {
            throw new MovieNotFoundException("Filme não encontrado");
        }

        return movie;
    }

}
