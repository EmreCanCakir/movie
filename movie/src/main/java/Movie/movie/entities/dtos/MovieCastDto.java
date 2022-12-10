package Movie.movie.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCastDto {
    private int id;
    private int movieId;
    private int actorId;
    private String role;
}
