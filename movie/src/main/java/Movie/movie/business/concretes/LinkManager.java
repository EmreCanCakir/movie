package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.LinkService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.core.utilities.results.Result;
import Movie.movie.dataaccess.LinkDao;
import Movie.movie.entities.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkManager implements LinkService {
    private LinkDao linkDao;

    @Autowired
    public LinkManager(LinkDao linkDao) {
        this.linkDao = linkDao;
    }

    @Override
    public Result add(Link entity) {
        return null;
    }

    @Override
    public Result delete(int id) {
        return null;
    }

    @Override
    public Result update(Link entity) {
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
