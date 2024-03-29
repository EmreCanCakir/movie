package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.MovieCastService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.MovieCastDao;
import Movie.movie.entities.MovieCast;
import Movie.movie.entities.dtos.MovieCastDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class MovieCastManager implements MovieCastService {
    private MovieCastDao movieCastDao;
    private final ModelMapper modelMapper;

    @Autowired
    public MovieCastManager(MovieCastDao movieCastDao, ModelMapper modelMapper) {
        this.movieCastDao = movieCastDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(MovieCastDto entity) {
        if (entity.getMovieId() == 0 || entity.getActorId() == 0) {
            log.error(CONSTANTS.MOVIE_CAST_NOT_ADD);
            return new ErrorResult(CONSTANTS.MOVIE_CAST_NOT_ADD);
        }
        MovieCast movieCast = modelMapper.map(entity, MovieCast.class);
        movieCastDao.save(movieCast);
        return new SuccessResult(CONSTANTS.MOVIE_CAST_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        MovieCast movieCast = this.movieCastDao.findById(id).orElse(new MovieCast());
        if (movieCast.getMovieId().getId() == 0 || movieCast.getActorId().getId() == 0) {
            log.error(CONSTANTS.MOVIE_CAST_NOT_DELETE);
            return new ErrorResult(CONSTANTS.MOVIE_CAST_NOT_DELETE);
        }
        this.movieCastDao.delete(movieCast);
        return new SuccessResult(CONSTANTS.MOVIE_CAST_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(MovieCastDto entity) {
        if (entity.getMovieId() == 0 || entity.getActorId() == 0) {
            log.error(CONSTANTS.MOVIE_CAST_NOT_UPDATE);
            return new ErrorResult(CONSTANTS.MOVIE_CAST_NOT_UPDATE);
        }
        MovieCast movieCast = modelMapper.map(entity, MovieCast.class);
        movieCastDao.save(movieCast);
        return new SuccessResult(CONSTANTS.MOVIE_CAST_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        MovieCast movieCast = movieCastDao.findById(id).orElse(new MovieCast());
        if (movieCast.getMovieId().getId() == 0) {
            log.warn(CONSTANTS.MOVIE_CAST_NOT_FOUND);
            return new ErrorDataResult(CONSTANTS.MOVIE_CAST_NOT_FOUND);
        }
        return new SuccessDataResult(movieCast, CONSTANTS.MOVIE_CAST_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.movieCastDao.findAll(), CONSTANTS.MOVIE_CAST_GET_ALL_SUCCESSFULLY);
    }
}
