package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.MovieDirectionService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.entities.MovieDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movie_direction_controller")
public class MovieDirectionsController {
    private MovieDirectionService movieDirectionService;

    @Autowired
    public MovieDirectionsController(MovieDirectionService movieDirectionService) {
        this.movieDirectionService = movieDirectionService;
    }

    @GetMapping("/getAll")
    public DataResult<List<MovieDirection>> getAll() {
        return this.movieDirectionService.getAll();
    }
}
