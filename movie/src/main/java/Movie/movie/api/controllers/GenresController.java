package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.GenreService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.entities.dtos.GenreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/genre_controller")
public class GenresController {
    private GenreService genreService;

    @Autowired
    public GenresController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody GenreDto genre){
        return CONSTANTS.getResponseEntity(this.genreService.add(genre));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id){
        return CONSTANTS.getResponseEntity(this.genreService.delete(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody GenreDto genre) {
        return CONSTANTS.getResponseEntity(this.genreService.update(genre));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam("id") int id) {
        return CONSTANTS.getResponseEntity(this.genreService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return CONSTANTS.getResponseEntity(this.genreService.getAll());
    }
}
