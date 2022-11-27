package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.MovieItemService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.entities.dtos.MovieItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie_item_controller")
public class MovieItemsController {
    private MovieItemService movieItemService;

    @Autowired
    public MovieItemsController(MovieItemService movieItemService) {
        this.movieItemService = movieItemService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody MovieItemDto movieItemDto){
        return CONSTANTS.getResponseEntity(this.movieItemService.add(movieItemDto));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id){
        return CONSTANTS.getResponseEntity(this.movieItemService.delete(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody MovieItemDto movieItemDto) {
        return CONSTANTS.getResponseEntity(this.movieItemService.update(movieItemDto));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam("id") int id) {
        return CONSTANTS.getResponseEntity(this.movieItemService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return CONSTANTS.getResponseEntity(this.movieItemService.getAll());
    }

}
