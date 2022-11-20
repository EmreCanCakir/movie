package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.MovieService;
import Movie.movie.business.abstracts.UserService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.UserDao;
import Movie.movie.entities.Movie;
import Movie.movie.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User entity) {
        if (entity.getEmail().isEmpty() || entity.getPassword().isEmpty() || entity.getUserName().isEmpty()) {
            return new ErrorResult(CONSTANTS.USER_NOT_ADD);
        }
        userDao.save(entity);
        return new SuccessResult(CONSTANTS.USER_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        User user = this.userDao.findById(id).orElse(null);
        if (user.getEmail().isEmpty()) {
            return new ErrorResult(CONSTANTS.USER_NOT_DELETE);
        }
        this.userDao.delete(user);
        return new SuccessResult(CONSTANTS.USER_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(User entity) {
        if (entity.getEmail().isEmpty() || entity.getPassword().isEmpty() || entity.getUserName().isEmpty()) {
            return new ErrorResult(CONSTANTS.USER_NOT_UPDATE);
        }
        userDao.save(entity);
        return new SuccessResult(CONSTANTS.USER_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        User user = userDao.findById(id).orElse(null);;
        return user == null ?
                new ErrorDataResult(CONSTANTS.USER_NOT_FOUND) :
                new SuccessDataResult(user, CONSTANTS.USER_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.userDao.findAll(), CONSTANTS.USER_GET_ALL_SUCCESSFULLY);
    }
}
