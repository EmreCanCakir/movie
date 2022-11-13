package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/photo_controller")
public class PhotosController {
    private PhotoService photoService;

    @Autowired
    public PhotosController(PhotoService photoService) {
        this.photoService = photoService;
    }
}
