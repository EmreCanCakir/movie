package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.MovieItemService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.MovieItemDao;
import Movie.movie.entities.MovieItem;
import Movie.movie.entities.dtos.MovieItemDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MovieItemManager implements MovieItemService {
    private MovieItemDao movieItemDao;
    private final ModelMapper modelMapper;

    @Autowired
    public MovieItemManager(MovieItemDao movieItemDao, ModelMapper modelMapper) {
        this.movieItemDao = movieItemDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(MovieItemDto entity) {
        if (entity.getMovieId() == 0 || entity.getDescription() == null) {
            log.error(CONSTANTS.MOVIE_ITEM_NOT_ADD);
            return new ErrorResult(CONSTANTS.MOVIE_ITEM_NOT_ADD);
        }
        MovieItem movieItem = modelMapper.map(entity,MovieItem.class);
        movieItemDao.save(movieItem);
        return new SuccessResult(CONSTANTS.MOVIE_ITEM_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        MovieItem movieItem = this.movieItemDao.findById(id).orElse(new MovieItem());
        if (movieItem.getMovie() == null || movieItem.getDescription() == null) {
            log.error(CONSTANTS.MOVIE_ITEM_NOT_DELETE);
            return new ErrorResult(CONSTANTS.MOVIE_ITEM_NOT_DELETE);
        }
        this.movieItemDao.delete(movieItem);
        return new SuccessResult(CONSTANTS.MOVIE_ITEM_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(MovieItemDto entity) {
        if (entity.getMovieId() == 0 || entity.getDescription() == null) {
            log.error(CONSTANTS.MOVIE_ITEM_NOT_UPDATE);
            return new ErrorResult(CONSTANTS.MOVIE_ITEM_NOT_UPDATE);
        }
        MovieItem movieItem = modelMapper.map(entity,MovieItem.class);
        movieItemDao.save(movieItem);
        return new SuccessResult(CONSTANTS.MOVIE_ITEM_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        MovieItem movieItem = movieItemDao.findById(id).orElse(new MovieItem());
        if (movieItem.getMovie() == null || movieItem.getDescription() == null) {
            log.error(CONSTANTS.MOVIE_ITEM_NOT_FOUND);
            return new ErrorDataResult(CONSTANTS.MOVIE_ITEM_NOT_FOUND);
        }
        return new SuccessDataResult(movieItem, CONSTANTS.MOVIE_ITEM_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.movieItemDao.findAll(), CONSTANTS.MOVIE_ITEM_GET_ALL_SUCCESSFULLY);
    }
}
