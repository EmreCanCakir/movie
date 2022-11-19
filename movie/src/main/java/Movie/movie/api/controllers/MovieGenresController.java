package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.MovieGenreService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.entities.MovieGenres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movie_genres_controller")
public class MovieGenresController {
    private MovieGenreService movieGenreService;

    @Autowired
    public MovieGenresController(MovieGenreService movieGenreService) {
        this.movieGenreService = movieGenreService;
    }

    @GetMapping("/getAll")
    public DataResult<List<MovieGenres>> getAll() {
        return this.movieGenreService.getAll();
    }

}
