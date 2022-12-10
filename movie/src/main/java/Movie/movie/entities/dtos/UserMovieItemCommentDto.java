package Movie.movie.entities.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserMovieItemCommentDto implements Serializable {
    private int id;
    private String commentName;
    private int userId;
    private int movieItemId;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
}
