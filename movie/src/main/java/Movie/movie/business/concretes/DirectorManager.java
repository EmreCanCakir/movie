package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.DirectorService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.DirectorDao;
import Movie.movie.entities.Director;
import Movie.movie.entities.dtos.DirectorDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DirectorManager implements DirectorService {
    private DirectorDao directorDao;
    private final ModelMapper modelMapper;
    @Autowired
    public DirectorManager(DirectorDao directorDao, ModelMapper modelMapper) {
        this.directorDao = directorDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(DirectorDto entity) {
        if (entity.getFirstName().length() < 3) {
            log.error(CONSTANTS.DIRECTOR_NOT_ADD);
            return new ErrorResult(CONSTANTS.DIRECTOR_NOT_ADD);
        }
        Director director = modelMapper.map(entity, Director.class);
        directorDao.save(director);
        return new SuccessResult(CONSTANTS.DIRECTOR_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        Director director = this.directorDao.findById(id).orElse(new Director());
        if (director.getFirstName() == null) {
            log.error(CONSTANTS.DIRECTOR_NOT_DELETE);
            return new ErrorResult(CONSTANTS.DIRECTOR_NOT_DELETE);
        }
        this.directorDao.delete(director);
        return new SuccessResult(CONSTANTS.DIRECTOR_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(DirectorDto entity) {
        if (entity.getFirstName().length() < 3) {
            log.error(CONSTANTS.DIRECTOR_NOT_UPDATE);
            return new ErrorResult(CONSTANTS.DIRECTOR_NOT_UPDATE);
        }
        Director director = modelMapper.map(entity, Director.class);
        directorDao.save(director);
        return new SuccessResult(CONSTANTS.DIRECTOR_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        Director director = directorDao.findById(id).orElse(new Director());
        if (director.getFirstName() == null){
            log.error(CONSTANTS.DIRECTOR_NOT_FOUND);
            return new ErrorDataResult(CONSTANTS.DIRECTOR_NOT_FOUND);
        }
        return new SuccessDataResult(director, CONSTANTS.DIRECTOR_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.directorDao.findAll(), CONSTANTS.DIRECTOR_GET_ALL_SUCCESSFULLY);
    }
}
