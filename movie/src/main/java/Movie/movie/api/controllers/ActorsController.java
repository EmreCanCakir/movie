package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.ActorService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.entities.Actor;
import Movie.movie.entities.dtos.ActorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actor_controller")
public class ActorsController {
    private ActorService actorService;

    @Autowired
    public ActorsController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ActorDto actor){
        return CONSTANTS.getResponseEntity(this.actorService.add(actor));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id){
        return CONSTANTS.getResponseEntity(this.actorService.delete(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ActorDto actor) {
        return CONSTANTS.getResponseEntity(this.actorService.update(actor));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam("id") int id) {
        return CONSTANTS.getResponseEntity(this.actorService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return CONSTANTS.getResponseEntity(this.actorService.getAll());
    }
}
