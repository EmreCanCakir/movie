package Movie.movie.dataaccess;

import Movie.movie.entities.UserMovieItemComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMovieItemCommentDao extends JpaRepository<UserMovieItemComment, Integer> {
}
