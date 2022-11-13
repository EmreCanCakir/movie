package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.MovieService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.core.utilities.results.Result;
import Movie.movie.dataaccess.UserDao;
import Movie.movie.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements MovieService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
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
        return null;
    }
}
