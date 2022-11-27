package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.UserMovieItemCommentService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.entities.UserMovieItemComment;
import Movie.movie.entities.dtos.PhotoDto;
import Movie.movie.entities.dtos.UserMovieItemCommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user_movie_item_comment_controller")
public class UserMovieItemCommentsController {
    private UserMovieItemCommentService userMovieItemCommentService;

    @Autowired
    public UserMovieItemCommentsController(UserMovieItemCommentService userMovieItemCommentService) {
        this.userMovieItemCommentService = userMovieItemCommentService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody UserMovieItemCommentDto userMovieItemCommentDto){
        return CONSTANTS.getResponseEntity(this.userMovieItemCommentService.add(userMovieItemCommentDto));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id){
        return CONSTANTS.getResponseEntity(this.userMovieItemCommentService.delete(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserMovieItemCommentDto userMovieItemCommentDto) {
        return CONSTANTS.getResponseEntity(this.userMovieItemCommentService.update(userMovieItemCommentDto));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam("id") int id) {
        return CONSTANTS.getResponseEntity(this.userMovieItemCommentService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return CONSTANTS.getResponseEntity(this.userMovieItemCommentService.getAll());
    }
}
