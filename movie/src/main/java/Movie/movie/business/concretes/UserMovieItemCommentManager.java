package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.UserMovieItemCommentService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.UserMovieItemCommentDao;
import Movie.movie.entities.Movie;
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
        if (entity.getCommentName().isEmpty()) {
            return new ErrorResult(CONSTANTS.USER_MOVIE_ITEM_COMMENT_NOT_ADD);
        }
        userMovieItemCommentDao.save(entity);
        return new SuccessResult(CONSTANTS.USER_MOVIE_ITEM_COMMENT_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        UserMovieItemComment userMovieItemComment = this.userMovieItemCommentDao.findById(id).orElse(null);
        if (userMovieItemComment.getCommentName().isEmpty()) {
            return new ErrorResult(CONSTANTS.USER_MOVIE_ITEM_COMMENT_NOT_DELETE);
        }
        this.userMovieItemCommentDao.delete(userMovieItemComment);
        return new SuccessResult(CONSTANTS.USER_MOVIE_ITEM_COMMENT_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(UserMovieItemComment entity) {
        if (entity.getCommentName().isEmpty()) {
            return new ErrorResult(CONSTANTS.USER_MOVIE_ITEM_COMMENT_NOT_UPDATE);
        }
        userMovieItemCommentDao.save(entity);
        return new SuccessResult(CONSTANTS.USER_MOVIE_ITEM_COMMENT_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        UserMovieItemComment userMovieItemComment = userMovieItemCommentDao.findById(id).orElse(null);;
        return userMovieItemComment == null ?
                new ErrorDataResult(CONSTANTS.USER_MOVIE_ITEM_COMMENT_NOT_FOUND) :
                new SuccessDataResult(userMovieItemComment, CONSTANTS.USER_MOVIE_ITEM_COMMENT_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.userMovieItemCommentDao.findAll(), CONSTANTS.USER_MOVIE_ITEM_COMMENT_GET_ALL_SUCCESSFULLY);
    }
}
