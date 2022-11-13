package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.MovieGenreService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.core.utilities.results.Result;
import Movie.movie.dataaccess.MovieGenreDao;
import Movie.movie.entities.MovieGenres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieGenreManager implements MovieGenreService {
    private MovieGenreDao movieGenreDao;

    @Autowired
    public MovieGenreManager(MovieGenreDao movieGenreDao) {
        this.movieGenreDao = movieGenreDao;
    }

    @Override
    public Result add(MovieGenres entity) {
        return null;
    }

    @Override
    public Result delete(int id) {
        return null;
    }

    @Override
    public Result update(MovieGenres entity) {
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
