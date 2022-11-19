package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.MovieService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.core.utilities.results.Result;
import Movie.movie.core.utilities.results.SuccessDataResult;
import Movie.movie.dataaccess.MovieDao;
import Movie.movie.entities.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieManager implements MovieService {
    private MovieDao movieDao;

    public MovieManager(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Result add(Movie entity) {
        return null;
    }

    @Override
    public Result delete(int id) {
        return null;
    }

    @Override
    public Result update(Movie entity) {
        return null;
    }

    @Override
    public DataResult getById(int id) {
        return null;
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.movieDao.findAll(),"all movies get");
    }
}
