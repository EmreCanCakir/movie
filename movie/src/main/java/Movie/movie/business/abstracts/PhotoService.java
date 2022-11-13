package Movie.movie.business.abstracts;

import Movie.movie.core.business.BaseService;
import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.core.utilities.results.Result;
import Movie.movie.entities.Photo;

public interface PhotoService extends BaseService<Photo> {
    Result delete(String id);
    DataResult getById(String id);
}
