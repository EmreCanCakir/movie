package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.MovieDirectionService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.core.utilities.results.Result;
import Movie.movie.dataaccess.MovieDirectionDao;
import Movie.movie.entities.MovieDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieDirectionManager implements MovieDirectionService {
    private MovieDirectionDao movieDirectionDao;

    @Autowired
    public MovieDirectionManager(MovieDirectionDao movieDirectionDao) {
        this.movieDirectionDao = movieDirectionDao;
    }

    @Override
    public Result add(MovieDirection entity) {
        return null;
    }

    @Override
    public Result delete(int id) {
        return null;
    }

    @Override
    public Result update(MovieDirection entity) {
        return null;
    }

    @Override
    public DataResult getById(int id) {
        return null;
    }

    @Override
    public DataResult getAll() {
        return null;
    }
}
