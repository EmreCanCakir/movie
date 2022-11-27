package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.UserService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.UserDao;
import Movie.movie.entities.User;
import Movie.movie.entities.dtos.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private UserDao userDao;
    private final ModelMapper modelMapper;

    @Autowired
    public UserManager(UserDao userDao, ModelMapper modelMapper) {
        this.userDao = userDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(UserDto entity) {
        if (entity.getEmail().isEmpty() || entity.getPassword().isEmpty() || entity.getUserName().isEmpty()) {
            return new ErrorResult(CONSTANTS.USER_NOT_ADD);
        }
        User user = modelMapper.map(entity, User.class);
        userDao.save(user);
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
    public Result update(UserDto entity) {
        if (entity.getEmail().isEmpty() || entity.getPassword().isEmpty() || entity.getUserName().isEmpty()) {
            return new ErrorResult(CONSTANTS.USER_NOT_UPDATE);
        }
        User user = modelMapper.map(entity, User.class);
        userDao.save(user);
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
