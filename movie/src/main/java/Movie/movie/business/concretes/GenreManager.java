package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.GenreService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.GenreDao;
import Movie.movie.entities.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreManager implements GenreService {
    private GenreDao genreDao;

    @Autowired
    public GenreManager(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public Result add(Genre entity) {
        if (entity.getGenreName().isEmpty()) {
            return new ErrorResult(CONSTANTS.GENRE_NOT_ADD);
        }
        genreDao.save(entity);
        return new SuccessResult(CONSTANTS.GENRE_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        Genre genre = this.genreDao.findById(id).get();
        if (genre.getGenreName().isEmpty()) {
            return new ErrorResult(CONSTANTS.GENRE_NOT_DELETE);
        }
        this.genreDao.delete(genre);
        return new SuccessResult(CONSTANTS.GENRE_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(Genre entity) {
        if (entity.getGenreName().isEmpty()) {
            return new ErrorResult(CONSTANTS.GENRE_NOT_UPDATE);
        }
        genreDao.save(entity);
        return new SuccessResult(CONSTANTS.GENRE_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        Genre genre = genreDao.findById(id).get();
        return genre.getGenreName().isEmpty() ?
                new ErrorDataResult(CONSTANTS.GENRE_NOT_FOUND) :
                new SuccessDataResult(genre, CONSTANTS.GENRE_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.genreDao.findAll(), CONSTANTS.GENRE_GET_ALL_SUCCESSFULLY);
    }
}
