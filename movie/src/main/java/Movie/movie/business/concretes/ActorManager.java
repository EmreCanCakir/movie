package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.ActorService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.ActorDao;
import Movie.movie.entities.Actor;
import Movie.movie.entities.dtos.ActorDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorManager implements ActorService {
    private ActorDao actorDao;
    private final ModelMapper modelMapper;

    @Autowired
    public ActorManager(ActorDao actorDao, ModelMapper modelMapper) {
        this.actorDao = actorDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(ActorDto entity) {
        if (entity.getFirstName().length() < 3) {
            return new ErrorResult(CONSTANTS.ACTOR_NOT_ADD);
        }
        Actor actor = modelMapper.map(entity, Actor.class);
        actorDao.save(actor);
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
    public Result update(ActorDto entity) {
        if (entity.getFirstName().length() < 3) {
            return new ErrorResult(CONSTANTS.ACTOR_NOT_UPDATE);
        }
        Actor actor = modelMapper.map(entity, Actor.class);
        actorDao.save(actor);
        return new SuccessResult(CONSTANTS.ACTOR_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        Actor actor = actorDao.findById(id).orElse(null);
        return actor.getFirstName().isEmpty() ?
                new ErrorDataResult(CONSTANTS.ACTOR_NOT_FOUND) :
                new SuccessDataResult(actor, CONSTANTS.ACTOR_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.actorDao.findAll(), CONSTANTS.ACTORS_GET_ALL_SUCCESSFULLY);
    }
}
