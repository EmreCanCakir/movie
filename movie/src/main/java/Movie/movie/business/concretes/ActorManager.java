package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.ActorService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.core.utilities.results.Result;
import Movie.movie.dataaccess.ActorDao;
import Movie.movie.entities.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorManager implements ActorService {
    private ActorDao actorDao;

    @Autowired
    public ActorManager(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    @Override
    public Result add(Actor entity) {
        return null;
    }

    @Override
    public Result delete(int id) {
        return null;
    }

    @Override
    public Result update(Actor entity) {
        return null;
    }

    @Override
    public DataResult getById(int id) {
        return null;
    }

    @Override
    public DataResult getAll() {
        return null;
    }
}
