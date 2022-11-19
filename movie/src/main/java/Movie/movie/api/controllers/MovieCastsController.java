package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.MovieCastService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.entities.MovieCast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/movie_cast_controller")
public class MovieCastsController {
    private MovieCastService movieCastService;

    @Autowired
    public MovieCastsController(MovieCastService movieCastService) {
        this.movieCastService = movieCastService;
    }

    @GetMapping("/getAll")
    public DataResult<List<MovieCast>> getAll() {
        return this.movieCastService.getAll();
    }
}
