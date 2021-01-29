package com.filmplex.movies.services

import com.filmplex.movies.MoviesApplication
import com.filmplex.movies.model.Movie
import com.filmplex.movies.model.MovieDetail
import com.filmplex.movies.model.MovieResult
import com.filmplex.movies.service.MovieService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest(classes = MoviesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application.yml")
class MovieServiceSpec extends Specification {

    @Autowired
    private MovieService movieService

    def "Deve listar os filmes" () {
        when: "acessar a listagem de filmes"
            MovieResult movieResult = movieService.list(1)
        then: "recebo a lista com os filmes"
            movieResult != null
            movieResult.getMovies().size() > 0
    }

    @Unroll
    def "Deve buscar um filme pelo código #id" (Long id, String title) {
        when: "acessar o detalhe do filme"
            MovieDetail movie = movieService.findById(id)
            print movie
        then: "recebo um filme"
            movie != null
            movie.id == id
            movie.title == title

        where:
            id      | title
            545609  | "Resgate"
            338762  | "Bloodshot"

    }

}
