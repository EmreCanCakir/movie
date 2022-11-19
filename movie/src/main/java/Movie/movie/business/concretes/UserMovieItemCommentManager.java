package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.UserMovieItemCommentService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.core.utilities.results.Result;
import Movie.movie.core.utilities.results.SuccessDataResult;
import Movie.movie.dataaccess.UserMovieItemCommentDao;
import Movie.movie.entities.UserMovieItemComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMovieItemCommentManager implements UserMovieItemCommentService {
    private UserMovieItemCommentDao userMovieItemCommentDao;

    @Autowired
    public UserMovieItemCommentManager(UserMovieItemCommentDao userMovieItemCommentDao) {
        this.userMovieItemCommentDao = userMovieItemCommentDao;
    }

    @Override
    public Result add(UserMovieItemComment entity) {
        return null;
    }

    @Override
    public Result delete(int id) {
        return null;
    }

    @Override
    public Result update(UserMovieItemComment entity) {
        return null;
    }

    @Override
    public DataResult getById(int id) {
        return null;
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.userMovieItemCommentDao.findAll(),"all user movie item comments get");
    }
}
