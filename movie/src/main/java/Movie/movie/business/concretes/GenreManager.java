package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.GenreService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.GenreDao;
import Movie.movie.entities.Genre;
import Movie.movie.entities.dtos.GenreDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreManager implements GenreService {
    private GenreDao genreDao;
    private final ModelMapper modelMapper;

    @Autowired
    public GenreManager(GenreDao genreDao, ModelMapper modelMapper) {
        this.genreDao = genreDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(GenreDto entity) {
        if (entity.getGenreName().isEmpty()) {
            return new ErrorResult(CONSTANTS.GENRE_NOT_ADD);
        }
        Genre genre = modelMapper.map(entity, Genre.class);
        genreDao.save(genre);
        return new SuccessResult(CONSTANTS.GENRE_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        Genre genre = this.genreDao.findById(id).get();
        if (genre.getGenreName().isEmpty()) {
            return new ErrorResult(CONSTANTS.GENRE_NOT_DELETE);
        }
        this.genreDao.delete(genre);
        return new SuccessResult(CONSTANTS.GENRE_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(GenreDto entity) {
        if (entity.getGenreName().isEmpty()) {
            return new ErrorResult(CONSTANTS.GENRE_NOT_UPDATE);
        }
        Genre genre = modelMapper.map(entity, Genre.class);
        genreDao.save(genre);
        return new SuccessResult(CONSTANTS.GENRE_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        Genre genre = genreDao.findById(id).orElse(null);
        return genre.getGenreName().isEmpty() ?
                new ErrorDataResult(CONSTANTS.GENRE_NOT_FOUND) :
                new SuccessDataResult(genre, CONSTANTS.GENRE_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.genreDao.findAll(), CONSTANTS.GENRE_GET_ALL_SUCCESSFULLY);
    }
}
