package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/director_controller")
public class DirectorsController {
    private DirectorService directorService;

    @Autowired
    public DirectorsController(DirectorService directorService) {
        this.directorService = directorService;
    }
}
