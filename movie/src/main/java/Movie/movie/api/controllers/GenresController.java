package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.GenreService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.entities.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genre_controller")
public class GenresController {
    private GenreService genreService;

    @Autowired
    public GenresController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Genre>> getAll() {
        return this.genreService.getAll();
    }
}
