package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.LinkService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.core.utilities.results.SuccessDataResult;
import Movie.movie.entities.Link;
import Movie.movie.entities.dtos.LinkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/link_controller")
public class LinksController {
    private LinkService linkService;

    @Autowired
    public LinksController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody LinkDto link){
        return CONSTANTS.getResponseEntity(this.linkService.add(link));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id){
        return CONSTANTS.getResponseEntity(this.linkService.delete(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody LinkDto link) {
        return CONSTANTS.getResponseEntity(this.linkService.update(link));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam("id") int id) {
        return CONSTANTS.getResponseEntity(this.linkService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return CONSTANTS.getResponseEntity(this.linkService.getAll());
    }

}
