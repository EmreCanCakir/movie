package Movie.movie.dataaccess;

import Movie.movie.entities.MovieDirection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDirectionDao extends JpaRepository<MovieDirection, Integer> {
}
