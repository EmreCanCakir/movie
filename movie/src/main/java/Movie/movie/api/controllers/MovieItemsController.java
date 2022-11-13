package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.MovieItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie_item_controller")
public class MovieItemsController {
    private MovieItemService movieItemService;

    @Autowired
    public MovieItemsController(MovieItemService movieItemService) {
        this.movieItemService = movieItemService;
    }
}
