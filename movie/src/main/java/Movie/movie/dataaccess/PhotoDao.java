package Movie.movie.dataaccess;

import Movie.movie.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoDao extends JpaRepository<Photo, String> {
}
