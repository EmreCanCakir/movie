package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.MovieCastService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.core.utilities.results.Result;
import Movie.movie.dataaccess.MovieCastDao;
import Movie.movie.entities.MovieCast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieCastManager implements MovieCastService {
    private MovieCastDao movieCastDao;

    @Autowired
    public MovieCastManager(MovieCastDao movieCastDao) {
        this.movieCastDao = movieCastDao;
    }

    @Override
    public Result add(MovieCast entity) {
        return null;
    }

    @Override
    public Result delete(int id) {
        return null;
    }

    @Override
    public Result update(MovieCast entity) {
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
