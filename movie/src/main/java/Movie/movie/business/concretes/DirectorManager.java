package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.DirectorService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.core.utilities.results.Result;
import Movie.movie.core.utilities.results.SuccessDataResult;
import Movie.movie.dataaccess.ActorDao;
import Movie.movie.dataaccess.DirectorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorManager implements DirectorService {
    private DirectorDao directorDao;

    @Autowired
    public DirectorManager(DirectorDao directorDao) {
        this.directorDao = directorDao;
    }

    @Override
    public Result add(DirectorService entity) {
        return null;
    }

    @Override
    public Result delete(int id) {
        return null;
    }

    @Override
    public Result update(DirectorService entity) {
        return null;
    }

    @Override
    public DataResult getById(int id) {
        return null;
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.directorDao.findAll(),"all directors get");
    }
}
