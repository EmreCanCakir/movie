package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.GenreService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.core.utilities.results.Result;
import Movie.movie.dataaccess.GenreDao;
import Movie.movie.entities.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreManager implements GenreService {
    private GenreDao genreDao;

    @Autowired
    public GenreManager(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public Result add(Genre entity) {
        return null;
    }

    @Override
    public Result delete(int id) {
        return null;
    }

    @Override
    public Result update(Genre entity) {
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
