package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.DirectorService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.DirectorDao;
import Movie.movie.entities.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorManager implements DirectorService {
    private DirectorDao directorDao;

    @Autowired
    public DirectorManager(DirectorDao directorDao) {
        this.directorDao = directorDao;
    }

    @Override
    public Result add(Director entity) {
        if (entity.getFirstName().length() < 3) {
            return new ErrorResult(CONSTANTS.DIRECTOR_NOT_ADD);
        }
        directorDao.save(entity);
        return new SuccessResult(CONSTANTS.DIRECTOR_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        Director director = this.directorDao.findById(id).get();
        if (director.getFirstName().isEmpty()) {
            return new ErrorResult(CONSTANTS.DIRECTOR_NOT_DELETE);
        }
        this.directorDao.delete(director);
        return new SuccessResult(CONSTANTS.DIRECTOR_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(Director entity) {
        if (entity.getFirstName().length() < 3) {
            return new ErrorResult(CONSTANTS.DIRECTOR_NOT_UPDATE);
        }
        directorDao.save(entity);
        return new SuccessResult(CONSTANTS.DIRECTOR_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        Director director = directorDao.findById(id).get();
        return director.getFirstName().length() > 0 ?
                new ErrorDataResult(CONSTANTS.DIRECTOR_NOT_FOUND) :
                new SuccessDataResult(director, CONSTANTS.DIRECTOR_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.directorDao.findAll(), CONSTANTS.DIRECTOR_GET_ALL_SUCCESSFULLY);
    }
}
