package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.DirectorService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.entities.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/director_controller")
public class DirectorsController {
    private DirectorService directorService;

    @Autowired
    public DirectorsController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Director>> getAll() {
        return this.directorService.getAll();
    }
}
