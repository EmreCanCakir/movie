package Movie.movie.entities.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class PhotoDto implements Serializable {
    private int id;
    private final String name;
    private final String type;
    private final byte[] data;
    private final int movieId;
    private final int userMovieItemCommentId;
}
