package Movie.movie.entities.dtos;

import lombok.Data;

@Data
public class MovieGenreDto {
    private int id;
    private int movieId;
    private int genreId;
}
