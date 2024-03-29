package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.UserMovieItemCommentService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.UserMovieItemCommentDao;
import Movie.movie.entities.UserMovieItemComment;
import Movie.movie.entities.dtos.UserMovieItemCommentDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserMovieItemCommentManager implements UserMovieItemCommentService {
    private UserMovieItemCommentDao userMovieItemCommentDao;
    private final ModelMapper modelMapper;
    @Autowired
    public UserMovieItemCommentManager(UserMovieItemCommentDao userMovieItemCommentDao, ModelMapper modelMapper) {
        this.userMovieItemCommentDao = userMovieItemCommentDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(UserMovieItemCommentDto entity) {
        if (entity.getCommentName() == null) {
            log.error(CONSTANTS.USER_MOVIE_ITEM_COMMENT_NOT_ADD);
            return new ErrorResult(CONSTANTS.USER_MOVIE_ITEM_COMMENT_NOT_ADD);
        }
        UserMovieItemComment userMovieItemComment = modelMapper.map(entity, UserMovieItemComment.class);
        userMovieItemCommentDao.save(userMovieItemComment);
        return new SuccessResult(CONSTANTS.USER_MOVIE_ITEM_COMMENT_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        UserMovieItemComment userMovieItemComment = this.userMovieItemCommentDao.findById(id).orElse(new UserMovieItemComment());
        if (userMovieItemComment.getCommentName() == null) {
            log.error(CONSTANTS.USER_MOVIE_ITEM_COMMENT_NOT_DELETE);
            return new ErrorResult(CONSTANTS.USER_MOVIE_ITEM_COMMENT_NOT_DELETE);
        }
        this.userMovieItemCommentDao.delete(userMovieItemComment);
        return new SuccessResult(CONSTANTS.USER_MOVIE_ITEM_COMMENT_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(UserMovieItemCommentDto entity) {
        if (entity.getCommentName() == null) {
            log.error(CONSTANTS.USER_MOVIE_ITEM_COMMENT_NOT_UPDATE);
            return new ErrorResult(CONSTANTS.USER_MOVIE_ITEM_COMMENT_NOT_UPDATE);
        }
        UserMovieItemComment userMovieItemComment = modelMapper.map(entity, UserMovieItemComment.class);
        userMovieItemCommentDao.save(userMovieItemComment);
        return new SuccessResult(CONSTANTS.USER_MOVIE_ITEM_COMMENT_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        UserMovieItemComment userMovieItemComment = userMovieItemCommentDao.findById(id).orElse(new UserMovieItemComment());;
        if (userMovieItemComment.getCommentName() == null) {
            log.error(CONSTANTS.USER_MOVIE_ITEM_COMMENT_NOT_FOUND);
            return new ErrorDataResult(CONSTANTS.USER_MOVIE_ITEM_COMMENT_NOT_FOUND);
        }
        return new SuccessDataResult(userMovieItemComment, CONSTANTS.USER_MOVIE_ITEM_COMMENT_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.userMovieItemCommentDao.findAll(), CONSTANTS.USER_MOVIE_ITEM_COMMENT_GET_ALL_SUCCESSFULLY);
    }
}
