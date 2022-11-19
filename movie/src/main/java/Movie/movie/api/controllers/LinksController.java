package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.LinkService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.entities.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/link_controller")
public class LinksController {
    private LinkService linkService;

    @Autowired
    public LinksController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Link>> getAll() {
        return this.linkService.getAll();
    }
}
