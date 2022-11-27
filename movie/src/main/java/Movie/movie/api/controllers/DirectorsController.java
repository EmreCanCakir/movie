package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.DirectorService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.entities.Director;
import Movie.movie.entities.dtos.DirectorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/director_controller")
public class DirectorsController {
    private DirectorService directorService;

    @Autowired
    public DirectorsController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody DirectorDto director){
        return CONSTANTS.getResponseEntity(this.directorService.add(director));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id){
        return CONSTANTS.getResponseEntity(this.directorService.delete(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody DirectorDto director) {
        return CONSTANTS.getResponseEntity(this.directorService.update(director));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam("id") int id) {
        return CONSTANTS.getResponseEntity(this.directorService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return CONSTANTS.getResponseEntity(this.directorService.getAll());
    }
}
