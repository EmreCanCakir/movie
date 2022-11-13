package Movie.movie.dataaccess;

import Movie.movie.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkDao extends JpaRepository<Link, Integer> {
}
