package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.MovieItemService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.MovieItemDao;
import Movie.movie.entities.MovieGenres;
import Movie.movie.entities.MovieItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieItemManager implements MovieItemService {
    private MovieItemDao movieItemDao;

    @Autowired
    public MovieItemManager(MovieItemDao movieItemDao) {
        this.movieItemDao = movieItemDao;
    }

    @Override
    public Result add(MovieItem entity) {
        if (entity.getMovie() == null || entity.getDescription() == null) {
            return new ErrorResult(CONSTANTS.MOVIE_ITEM_NOT_ADD);
        }
        movieItemDao.save(entity);
        return new SuccessResult(CONSTANTS.MOVIE_ITEM_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        MovieItem movieItem = this.movieItemDao.findById(id).get();
        if (movieItem.getMovie() == null) {
            return new ErrorResult(CONSTANTS.MOVIE_ITEM_NOT_DELETE);
        }
        this.movieItemDao.delete(movieItem);
        return new SuccessResult(CONSTANTS.MOVIE_ITEM_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(MovieItem entity) {
        if (entity.getMovie() == null || entity.getDescription() == null) {
            return new ErrorResult(CONSTANTS.MOVIE_ITEM_NOT_UPDATE);
        }
        movieItemDao.save(entity);
        return new SuccessResult(CONSTANTS.MOVIE_ITEM_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        MovieItem movieItem = movieItemDao.findById(id).get();
        return movieItem.getMovie() == null ?
                new ErrorDataResult(CONSTANTS.MOVIE_ITEM_NOT_FOUND) :
                new SuccessDataResult(movieItem, CONSTANTS.MOVIE_ITEM_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.movieItemDao.findAll(), CONSTANTS.MOVIE_ITEM_GET_ALL_SUCCESSFULLY);
    }
}
