package Movie.movie.dataaccess;

import Movie.movie.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDao extends JpaRepository<Genre, Integer> {
}
