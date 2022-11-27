package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.MovieService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.MovieDao;
import Movie.movie.entities.Movie;
import Movie.movie.entities.dtos.MovieDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MovieManager implements MovieService {
    private MovieDao movieDao;
    private final ModelMapper modelMapper;

    public MovieManager(MovieDao movieDao, ModelMapper modelMapper) {
        this.movieDao = movieDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(MovieDto entity) {
        if (entity.getTitle() == null) {
            return new ErrorResult(CONSTANTS.MOVIE_NOT_ADD);
        }
        Movie movie = modelMapper.map(entity, Movie.class);
        movieDao.save(movie);
        return new SuccessResult(CONSTANTS.MOVIE_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        Movie movie = this.movieDao.findById(id).orElse(null);
        if (movie.getTitle() == null) {
            return new ErrorResult(CONSTANTS.MOVIE_NOT_DELETE);
        }
        this.movieDao.delete(movie);
        return new SuccessResult(CONSTANTS.MOVIE_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(MovieDto entity) {
        if (entity.getTitle() == null) {
            return new ErrorResult(CONSTANTS.MOVIE_NOT_UPDATE);
        }
        Movie movie = modelMapper.map(entity, Movie.class);
        movieDao.save(movie);
        return new SuccessResult(CONSTANTS.MOVIE_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        Movie movie = movieDao.findById(id).orElse(null);
        return movie == null ?
                new ErrorDataResult(CONSTANTS.MOVIE_NOT_FOUND) :
                new SuccessDataResult(movie, CONSTANTS.MOVIE_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.movieDao.findAll(), CONSTANTS.MOVIE_GET_ALL_SUCCESSFULLY);
    }
}
