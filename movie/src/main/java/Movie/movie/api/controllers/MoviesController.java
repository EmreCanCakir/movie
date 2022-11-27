package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.MovieService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.entities.dtos.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/movie_controller")
public class MoviesController {
    private MovieService movieService;

    @Autowired
    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody MovieDto movieDto){
        return CONSTANTS.getResponseEntity(this.movieService.add(movieDto));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id){
        return CONSTANTS.getResponseEntity(this.movieService.delete(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody MovieDto movieDto) {
        return CONSTANTS.getResponseEntity(this.movieService.update(movieDto));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam("id") int id) {
        return CONSTANTS.getResponseEntity(this.movieService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return CONSTANTS.getResponseEntity(this.movieService.getAll());
    }
}
