package Movie.movie.entities.dtos;

import lombok.Data;

@Data
public class MovieDirectionDto {
    private int id;
    private int movieId;
    private int directorId;
}
