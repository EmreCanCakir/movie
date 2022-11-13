package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.MovieCastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie_cast_controller")
public class MovieCastsController {
    private MovieCastService movieCastService;

    @Autowired
    public MovieCastsController(MovieCastService movieCastService) {
        this.movieCastService = movieCastService;
    }
}
