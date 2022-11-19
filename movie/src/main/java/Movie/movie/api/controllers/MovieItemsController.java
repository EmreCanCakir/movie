package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.MovieItemService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.entities.MovieItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movie_item_controller")
public class MovieItemsController {
    private MovieItemService movieItemService;

    @Autowired
    public MovieItemsController(MovieItemService movieItemService) {
        this.movieItemService = movieItemService;
    }

    @GetMapping("/getAll")
    public DataResult<List<MovieItem>> getAll() {
        return this.movieItemService.getAll();
    }

}
