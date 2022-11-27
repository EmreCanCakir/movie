package Movie.movie.entities.dtos;

import lombok.Data;

@Data
public class MovieCastDto {
    private int movieId;
    private int actorId;
    private String role;
}
