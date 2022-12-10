package Movie.movie.entities.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MovieItemDto implements Serializable {
    private int id;
    private String description;
    private int movieId;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
}
