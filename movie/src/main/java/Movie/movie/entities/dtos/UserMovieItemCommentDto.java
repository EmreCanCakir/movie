package Movie.movie.entities.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserMovieItemCommentDto implements Serializable {
    private final String commentName;
    private final int userId;
    private final int movieItemId;
    private final LocalDateTime createdAt;
    private final LocalDateTime lastModifiedAt;
}
