package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.MovieItemService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.core.utilities.results.Result;
import Movie.movie.core.utilities.results.SuccessDataResult;
import Movie.movie.dataaccess.MovieItemDao;
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
        return null;
    }

    @Override
    public Result delete(int id) {
        return null;
    }

    @Override
    public Result update(MovieItem entity) {
        return null;
    }

    @Override
    public DataResult getById(int id) {
        return null;
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.movieItemDao.findAll(),"all movie items get");
    }
}
