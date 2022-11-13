package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.MovieDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie_direction_controller")
public class MovieDirectionsController {
    private MovieDirectionService movieDirectionService;

    @Autowired
    public MovieDirectionsController(MovieDirectionService movieDirectionService) {
        this.movieDirectionService = movieDirectionService;
    }
}
