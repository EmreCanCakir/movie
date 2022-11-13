package Movie.movie.dataaccess;

import Movie.movie.entities.MovieGenres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieGenreDao extends JpaRepository<MovieGenres, Integer> {
}
