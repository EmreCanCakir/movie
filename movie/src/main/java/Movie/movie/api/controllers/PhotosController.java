package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.PhotoService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.entities.dtos.PhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photo_controller")
public class PhotosController {
    private PhotoService photoService;

    @Autowired
    public PhotosController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody PhotoDto photoDto){
        return CONSTANTS.getResponseEntity(this.photoService.add(photoDto));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") String id){
        return CONSTANTS.getResponseEntity(this.photoService.delete(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody PhotoDto photoDto) {
        return CONSTANTS.getResponseEntity(this.photoService.update(photoDto));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam("id") String id) {
        return CONSTANTS.getResponseEntity(this.photoService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return CONSTANTS.getResponseEntity(this.photoService.getAll());
    }
}
