package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.MovieGenreService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.MovieGenreDao;
import Movie.movie.entities.MovieGenres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieGenreManager implements MovieGenreService {
    private MovieGenreDao movieGenreDao;

    @Autowired
    public MovieGenreManager(MovieGenreDao movieGenreDao) {
        this.movieGenreDao = movieGenreDao;
    }

    @Override
    public Result add(MovieGenres entity) {
        if (entity.getMovieId().getId() == 0 || entity.getGenreId().getId() == 0) {
            return new ErrorResult(CONSTANTS.MOVIE_GENRE_NOT_ADD);
        }
        movieGenreDao.save(entity);
        return new SuccessResult(CONSTANTS.MOVIE_GENRE_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        MovieGenres movieGenres = this.movieGenreDao.findById(id).get();
        if (movieGenres.getMovieId().getId() == 0 || movieGenres.getGenreId().getId() == 0) {
            return new ErrorResult(CONSTANTS.MOVIE_GENRE_NOT_DELETE);
        }
        this.movieGenreDao.delete(movieGenres);
        return new SuccessResult(CONSTANTS.MOVIE_GENRE_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(MovieGenres entity) {
        if (entity.getMovieId().getId() == 0 || entity.getGenreId().getId() == 0) {
            return new ErrorResult(CONSTANTS.MOVIE_GENRE_NOT_UPDATE);
        }
        movieGenreDao.save(entity);
        return new SuccessResult(CONSTANTS.MOVIE_GENRE_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        MovieGenres movieGenres = movieGenreDao.findById(id).get();
        return movieGenres.getMovieId().getId() == 0 ?
                new ErrorDataResult(CONSTANTS.MOVIE_GENRE_NOT_FOUND) :
                new SuccessDataResult(movieGenres, CONSTANTS.MOVIE_GENRE_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.movieGenreDao.findAll(), CONSTANTS.MOVIE_GENRE_GET_ALL_SUCCESSFULLY);
    }
}
