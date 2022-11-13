package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.PhotoService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.core.utilities.results.Result;
import Movie.movie.dataaccess.PhotoDao;
import Movie.movie.entities.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoManager implements PhotoService {
    private PhotoDao photoDao;

    @Autowired
    public PhotoManager(PhotoDao photoDao) {
        this.photoDao = photoDao;
    }

    @Override
    public Result delete(String id) {
        return null;
    }

    @Override
    public DataResult getById(String id) {
        return null;
    }

    @Override
    public Result add(Photo entity) {
        return null;
    }

    @Override
    public Result delete(int id) {
        return null;
    }

    @Override
    public Result update(Photo entity) {
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
