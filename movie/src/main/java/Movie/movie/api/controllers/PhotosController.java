package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.PhotoService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.entities.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/photo_controller")
public class PhotosController {
    private PhotoService photoService;

    @Autowired
    public PhotosController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping ("/getAll")
    public DataResult<List<Photo>> getAll() {
        return this.photoService.getAll();
    }
}
