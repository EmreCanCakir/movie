package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.MovieGenreService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.MovieGenreDao;
import Movie.movie.entities.MovieGenres;
import Movie.movie.entities.dtos.MovieGenreDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MovieGenreManager implements MovieGenreService {
    private MovieGenreDao movieGenreDao;
    private final ModelMapper modelMapper;

    @Autowired
    public MovieGenreManager(MovieGenreDao movieGenreDao, ModelMapper modelMapper) {
        this.movieGenreDao = movieGenreDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(MovieGenreDto entity) {
        if (entity.getMovieId() == 0 || entity.getGenreId() == 0) {
            log.error(CONSTANTS.MOVIE_GENRE_NOT_ADD);
            return new ErrorResult(CONSTANTS.MOVIE_GENRE_NOT_ADD);
        }
        MovieGenres movieGenres = modelMapper.map(entity, MovieGenres.class);
        movieGenreDao.save(movieGenres);
        return new SuccessResult(CONSTANTS.MOVIE_GENRE_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        MovieGenres movieGenres = this.movieGenreDao.findById(id).orElse(new MovieGenres());
        if (movieGenres.getMovieId().getId() == 0 || movieGenres.getGenreId().getId() == 0) {
            log.error(CONSTANTS.MOVIE_GENRE_NOT_DELETE);
            return new ErrorResult(CONSTANTS.MOVIE_GENRE_NOT_DELETE);
        }
        this.movieGenreDao.delete(movieGenres);
        return new SuccessResult(CONSTANTS.MOVIE_GENRE_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(MovieGenreDto entity) {
        if (entity.getMovieId() == 0 || entity.getGenreId() == 0) {
            log.error(CONSTANTS.MOVIE_GENRE_NOT_UPDATE);
            return new ErrorResult(CONSTANTS.MOVIE_GENRE_NOT_UPDATE);
        }
        MovieGenres movieGenres = modelMapper.map(entity, MovieGenres.class);
        movieGenreDao.save(movieGenres);
        return new SuccessResult(CONSTANTS.MOVIE_GENRE_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        MovieGenres movieGenres = movieGenreDao.findById(id).orElse(new MovieGenres());
        if (movieGenres.getMovieId().getId() == 0) {
            log.warn(CONSTANTS.MOVIE_GENRE_NOT_FOUND);
            return new ErrorDataResult(CONSTANTS.MOVIE_GENRE_NOT_FOUND);
        }
        return new SuccessDataResult(movieGenres, CONSTANTS.MOVIE_GENRE_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.movieGenreDao.findAll(), CONSTANTS.MOVIE_GENRE_GET_ALL_SUCCESSFULLY);
    }
}
