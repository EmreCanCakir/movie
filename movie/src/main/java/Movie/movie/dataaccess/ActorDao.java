package Movie.movie.dataaccess;

import Movie.movie.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorDao extends JpaRepository<Actor,Integer> {

}
