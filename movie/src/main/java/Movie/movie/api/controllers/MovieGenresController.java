package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.MovieGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie_genres_controller")
public class MovieGenresController {
    private MovieGenreService movieGenreService;

    @Autowired
    public MovieGenresController(MovieGenreService movieGenreService) {
        this.movieGenreService = movieGenreService;
    }
}
