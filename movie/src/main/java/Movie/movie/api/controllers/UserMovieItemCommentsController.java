package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.UserMovieItemCommentService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.entities.UserMovieItemComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user_movie_item_comment_controller")
public class UserMovieItemCommentsController {
    private UserMovieItemCommentService userMovieItemCommentService;

    @Autowired
    public UserMovieItemCommentsController(UserMovieItemCommentService userMovieItemCommentService) {
        this.userMovieItemCommentService = userMovieItemCommentService;
    }

    @GetMapping("/getAll")
    public DataResult<List<UserMovieItemComment>> getAll() {
        return this.userMovieItemCommentService.getAll();
    }
}
