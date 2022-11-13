package Movie.movie.core.business;

import Movie.movie.core.utilities.results.DataResult;
import Movie.movie.core.utilities.results.Result;

public interface BaseService <T>{
    Result add(T entity);
    Result delete(int id);
    Result update(T entity);
    DataResult getById(int id);
    DataResult getAll();
}
