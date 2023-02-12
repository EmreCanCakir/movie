package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.PhotoService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.PhotoDao;
import Movie.movie.entities.Photo;
import Movie.movie.entities.dtos.PhotoAddDto;
import Movie.movie.entities.dtos.PhotoDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
public class PhotoManager implements PhotoService {
    private PhotoDao photoDao;
    private final ModelMapper modelMapper;

    @Autowired
    public PhotoManager(PhotoDao photoDao, ModelMapper modelMapper) {
        this.photoDao = photoDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(PhotoAddDto photoAddDto, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            PhotoDto photoDto = new PhotoDto(photoAddDto.getId(), fileName, file.getContentType(), file.getBytes(), photoAddDto.getMovieId());

            //ToDo: get Movie with getMovieId and validate movie Information
            if (photoDto.getName() == null || !(photoDto.getData().length > 0)) {
                log.error(CONSTANTS.PHOTO_NOT_ADD);
                return new ErrorResult(CONSTANTS.PHOTO_NOT_ADD);
            }
            Photo photo = modelMapper.map(photoDto, Photo.class);
            photoDao.save(photo);
            return new SuccessResult(CONSTANTS.PHOTO_ADD_SUCCESSFULLY);
        } catch (IOException e) {
            e.printStackTrace();
            log.error(CONSTANTS.PHOTO_NOT_ADD);
            return new ErrorResult(CONSTANTS.PHOTO_NOT_ADD);
        }
    }

    @Override
    public Result delete(String id) {
        Photo photo = this.photoDao.findById(id).orElse(new Photo());
        if (photo.getName() == null || !(photo.getData().length > 0)) {
            log.error(CONSTANTS.PHOTO_NOT_DELETE);
            return new ErrorResult(CONSTANTS.PHOTO_NOT_DELETE);
        }
        this.photoDao.delete(photo);
        return new SuccessResult(CONSTANTS.PHOTO_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(PhotoAddDto photoAddDto, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            byte[] data = file.getBytes();
            if (file.getName().isEmpty() || !(data.length > 0)) {
                log.error(CONSTANTS.PHOTO_NOT_UPDATE);
                return new ErrorResult(CONSTANTS.PHOTO_NOT_UPDATE);
            }

            PhotoDto photoDto = new PhotoDto(photoAddDto.getId(), fileName, file.getContentType(), data, photoAddDto.getMovieId());
            Photo photo = modelMapper.map(photoDto, Photo.class);
            photoDao.save(photo);
            return new SuccessResult(CONSTANTS.PHOTO_UPDATE_SUCCESSFULLY);

        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorResult(CONSTANTS.PHOTO_NOT_UPDATE);
        }
    }

    @Override
    public DataResult getById(String id) {
        Photo photo = photoDao.findById(id).orElse(new Photo());
        if (photo.getName() == null || !(photo.getData().length > 0)) {
            log.warn(CONSTANTS.MOVIE_NOT_FOUND);
            return new ErrorDataResult(CONSTANTS.PHOTO_NOT_FOUND);
        }
        return new SuccessDataResult(photo, CONSTANTS.PHOTO_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(photoDao.findAll(), CONSTANTS.PHOTO_GET_ALL_SUCCESSFULLY);
    }
}
