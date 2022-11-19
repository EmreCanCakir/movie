package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.MovieService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movie_controller")
public class MoviesController {
    private MovieService movieService;

    @Autowired
    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Movie>> getAll() {
        return this.movieService.getAll();
    }
}
