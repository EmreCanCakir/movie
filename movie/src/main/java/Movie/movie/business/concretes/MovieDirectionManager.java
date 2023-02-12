package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.MovieDirectionService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.MovieDirectionDao;
import Movie.movie.entities.MovieDirection;
import Movie.movie.entities.dtos.MovieDirectionDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MovieDirectionManager implements MovieDirectionService {
    private MovieDirectionDao movieDirectionDao;
    private final ModelMapper modelMapper;

    @Autowired
    public MovieDirectionManager(MovieDirectionDao movieDirectionDao, ModelMapper modelMapper) {
        this.movieDirectionDao = movieDirectionDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(MovieDirectionDto entity) {
        if (entity.getMovieId() == 0 || entity.getDirectorId() == 0) {
            log.error(CONSTANTS.MOVIE_DIRECTION_NOT_ADD);
            return new ErrorResult(CONSTANTS.MOVIE_DIRECTION_NOT_ADD);
        }
        MovieDirection movieDirection = modelMapper.map(entity, MovieDirection.class);
        movieDirectionDao.save(movieDirection);
        return new SuccessResult(CONSTANTS.MOVIE_DIRECTION_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        MovieDirection movieDirection = this.movieDirectionDao.findById(id).orElse(new MovieDirection());
        if (movieDirection.getMovieId().getId() == 0 || movieDirection.getDirectorId().getId() == 0) {
            log.error(CONSTANTS.MOVIE_DIRECTION_NOT_DELETE);
            return new ErrorResult(CONSTANTS.MOVIE_DIRECTION_NOT_DELETE);
        }
        this.movieDirectionDao.delete(movieDirection);
        return new SuccessResult(CONSTANTS.MOVIE_DIRECTION_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(MovieDirectionDto entity) {
        if (entity.getMovieId() == 0 || entity.getDirectorId() == 0) {
            log.error(CONSTANTS.MOVIE_DIRECTION_NOT_UPDATE);
            return new ErrorResult(CONSTANTS.MOVIE_DIRECTION_NOT_UPDATE);
        }
        MovieDirection movieDirection = modelMapper.map(entity, MovieDirection.class);
        movieDirectionDao.save(movieDirection);
        return new SuccessResult(CONSTANTS.MOVIE_DIRECTION_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        MovieDirection movieDirection = movieDirectionDao.findById(id).orElse(new MovieDirection());
        if (movieDirection.getMovieId().getId() == 0) {
            log.warn(CONSTANTS.MOVIE_DIRECTION_NOT_FOUND);
            return new ErrorDataResult(CONSTANTS.MOVIE_DIRECTION_NOT_FOUND);
        }
        return new SuccessDataResult(movieDirection, CONSTANTS.MOVIE_DIRECTION_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.movieDirectionDao.findAll(), CONSTANTS.MOVIE_DIRECTION_GET_ALL_SUCCESSFULLY);
    }
}
