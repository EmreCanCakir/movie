package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.MovieCastService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.entities.dtos.MovieCastDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/movie_cast_controller")
public class MovieCastsController {
    private MovieCastService movieCastService;

    @Autowired
    public MovieCastsController(MovieCastService movieCastService) {
        this.movieCastService = movieCastService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody MovieCastDto movieCastDto){
        return CONSTANTS.getResponseEntity(this.movieCastService.add(movieCastDto));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id){
        return CONSTANTS.getResponseEntity(this.movieCastService.delete(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody MovieCastDto movieCastDto) {
        return CONSTANTS.getResponseEntity(this.movieCastService.update(movieCastDto));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam("id") int id) {
        return CONSTANTS.getResponseEntity(this.movieCastService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return CONSTANTS.getResponseEntity(this.movieCastService.getAll());
    }

}
