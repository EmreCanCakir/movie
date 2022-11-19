package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.ActorService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
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
        if (entity.getFirstName().length() < 3) {
            return new ErrorResult(CONSTANTS.ACTOR_NOT_ADD);
        }
        actorDao.save(entity);
        return new SuccessResult(CONSTANTS.ACTOR_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        Actor actor = this.actorDao.findById(id).get();
        if (actor.getFirstName().isEmpty()) {
            return new ErrorResult(CONSTANTS.ACTOR_NOT_DELETE);
        }
        this.actorDao.delete(actor);
        return new SuccessResult(CONSTANTS.ACTOR_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(Actor entity) {
        if (entity.getFirstName().length() < 3) {
            return new ErrorResult(CONSTANTS.ACTOR_NOT_UPDATE);
        }
        actorDao.save(entity);
        return new SuccessResult(CONSTANTS.ACTOR_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        Actor actor = actorDao.findById(id).get();
        return actor.getFirstName().length() > 0 ?
                new ErrorDataResult(CONSTANTS.ACTOR_NOT_FOUND) :
                new SuccessDataResult(actor, CONSTANTS.ACTOR_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.actorDao.findAll(), CONSTANTS.ACTORS_GET_ALL_SUCCESSFULLY);
    }
}
