package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.MovieDirectionService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.entities.dtos.MovieDirectionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movie_direction_controller")
public class MovieDirectionsController {
    private MovieDirectionService movieDirectionService;

    @Autowired
    public MovieDirectionsController(MovieDirectionService movieDirectionService) {
        this.movieDirectionService = movieDirectionService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody MovieDirectionDto movieDirectionDto){
        return CONSTANTS.getResponseEntity(this.movieDirectionService.add(movieDirectionDto));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id){
        return CONSTANTS.getResponseEntity(this.movieDirectionService.delete(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody MovieDirectionDto movieDirectionDto) {
        return CONSTANTS.getResponseEntity(this.movieDirectionService.update(movieDirectionDto));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam("id") int id) {
        return CONSTANTS.getResponseEntity(this.movieDirectionService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return CONSTANTS.getResponseEntity(this.movieDirectionService.getAll());
    }

}
