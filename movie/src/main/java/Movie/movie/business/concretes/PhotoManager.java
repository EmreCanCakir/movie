package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.PhotoService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.PhotoDao;
import Movie.movie.entities.Photo;
import Movie.movie.entities.dtos.PhotoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoManager implements PhotoService {
    private PhotoDao photoDao;
    private final ModelMapper modelMapper;

    @Autowired
    public PhotoManager(PhotoDao photoDao, ModelMapper modelMapper) {
        this.photoDao = photoDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result delete(String id) {
        Photo photo = this.photoDao.findById(id).orElse(null);
        if (photo == null) {
            return new ErrorResult(CONSTANTS.PHOTO_NOT_DELETE);
        }
        this.photoDao.delete(photo);
        return new SuccessResult(CONSTANTS.PHOTO_DELETE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(String id) {
        Photo photo = photoDao.findById(id).orElse(null);;
        return photo == null ?
                new ErrorDataResult(CONSTANTS.PHOTO_NOT_FOUND) :
                new SuccessDataResult(photo, CONSTANTS.PHOTO_GET_SUCCESSFULLY);
    }

    @Override
    public Result add(PhotoDto entity) {
        if (entity.getData().length < 10) {
            return new ErrorResult(CONSTANTS.PHOTO_NOT_ADD);
        }
        Photo photo = modelMapper.map(entity, Photo.class);
        photoDao.save(photo);
        return new SuccessResult(CONSTANTS.PHOTO_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        return null;
    }

    @Override
    public Result update(PhotoDto entity) {
        if (entity.getData() == null || entity.getName().isEmpty()) {
            return new ErrorResult(CONSTANTS.PHOTO_NOT_UPDATE);
        }
        Photo photo = modelMapper.map(entity, Photo.class);
        photoDao.save(photo);
        return new SuccessResult(CONSTANTS.PHOTO_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        return null;
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.photoDao.findAll(), CONSTANTS.PHOTO_GET_ALL_SUCCESSFULLY);
    }
}
