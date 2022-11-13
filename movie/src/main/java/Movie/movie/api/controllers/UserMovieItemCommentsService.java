package Movie.movie.api.controllers;

import Movie.movie.business.abstracts.UserMovieItemCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user_movie_item_comment_controller")
public class UserMovieItemCommentsService {
    private UserMovieItemCommentService userMovieItemCommentService;

    @Autowired
    public UserMovieItemCommentsService(UserMovieItemCommentService userMovieItemCommentService) {
        this.userMovieItemCommentService = userMovieItemCommentService;
    }
}
