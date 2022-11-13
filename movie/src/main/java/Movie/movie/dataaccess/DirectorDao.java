package Movie.movie.dataaccess;

import Movie.movie.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorDao extends JpaRepository<Director, Integer> {
}
