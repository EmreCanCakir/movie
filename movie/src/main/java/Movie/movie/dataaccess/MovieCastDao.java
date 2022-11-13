package Movie.movie.dataaccess;

import Movie.movie.entities.MovieCast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCastDao extends JpaRepository<MovieCast, Integer> {
}
