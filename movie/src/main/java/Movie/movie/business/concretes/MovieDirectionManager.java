package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.MovieDirectionService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.MovieDirectionDao;
import Movie.movie.entities.MovieCast;
import Movie.movie.entities.MovieDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieDirectionManager implements MovieDirectionService {
    private MovieDirectionDao movieDirectionDao;

    @Autowired
    public MovieDirectionManager(MovieDirectionDao movieDirectionDao) {
        this.movieDirectionDao = movieDirectionDao;
    }

    @Override
    public Result add(MovieDirection entity) {
        if (entity.getMovieId().getId() == 0 || entity.getDirectorId().getId() == 0) {
            return new ErrorResult(CONSTANTS.MOVIE_DIRECTION_NOT_ADD);
        }
        movieDirectionDao.save(entity);
        return new SuccessResult(CONSTANTS.MOVIE_DIRECTION_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        MovieDirection movieDirection = this.movieDirectionDao.findById(id).get();
        if (movieDirection.getMovieId().getId() == 0 || movieDirection.getDirectorId().getId() == 0) {
            return new ErrorResult(CONSTANTS.MOVIE_DIRECTION_NOT_DELETE);
        }
        this.movieDirectionDao.delete(movieDirection);
        return new SuccessResult(CONSTANTS.MOVIE_DIRECTION_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(MovieDirection entity) {
        if (entity.getMovieId().getId() == 0 || entity.getDirectorId().getId() == 0) {
            return new ErrorResult(CONSTANTS.MOVIE_DIRECTION_NOT_UPDATE);
        }
        movieDirectionDao.save(entity);
        return new SuccessResult(CONSTANTS.MOVIE_DIRECTION_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        MovieDirection movieDirection = movieDirectionDao.findById(id).get();
        return movieDirection.getMovieId().getId() == 0 ?
                new ErrorDataResult(CONSTANTS.MOVIE_DIRECTION_NOT_FOUND) :
                new SuccessDataResult(movieDirection, CONSTANTS.MOVIE_DIRECTION_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.movieDirectionDao.findAll(), CONSTANTS.MOVIE_DIRECTION_GET_ALL_SUCCESSFULLY);
    }
}
