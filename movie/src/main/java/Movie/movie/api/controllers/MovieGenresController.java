package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.MovieGenreService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.entities.dtos.MovieGenreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/movie_genres_controller")
public class MovieGenresController {
    private MovieGenreService movieGenreService;

    @Autowired
    public MovieGenresController(MovieGenreService movieGenreService) {
        this.movieGenreService = movieGenreService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody MovieGenreDto movieGenreDto){
        return CONSTANTS.getResponseEntity(this.movieGenreService.add(movieGenreDto));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id){
        return CONSTANTS.getResponseEntity(this.movieGenreService.delete(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody MovieGenreDto movieGenreDto) {
        return CONSTANTS.getResponseEntity(this.movieGenreService.update(movieGenreDto));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam("id") int id) {
        return CONSTANTS.getResponseEntity(this.movieGenreService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return CONSTANTS.getResponseEntity(this.movieGenreService.getAll());
    }

}
