package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.ActorService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.entities.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/actor_controller")
public class ActorsController {
    private ActorService actorService;

    @Autowired
    public ActorsController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Actor>> getAll() {
        return this.actorService.getAll();
    }
}
