package Movie.movie.business.abstracts;

import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.core.utilities.results.Result;
import Movie.movie.entities.dtos.PhotoAddDto;
import org.springframework.web.multipart.MultipartFile;


public interface PhotoService {
    Result add(PhotoAddDto photoAddDto, MultipartFile file);
    Result delete(String id);
    Result update(PhotoAddDto photoAddDto, MultipartFile file);
    DataResult getById(String id);
    DataResult getAll();
}
