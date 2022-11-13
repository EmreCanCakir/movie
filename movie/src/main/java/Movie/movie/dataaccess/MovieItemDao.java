package Movie.movie.dataaccess;

import Movie.movie.entities.MovieItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieItemDao extends JpaRepository<MovieItem, Integer> {
}
