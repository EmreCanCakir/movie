package Movie.movie.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class PhotoDto implements Serializable {
    private String id;
    private String name;
    private String type;
    private byte[] data;
    private int movieId;
  //  private int userMovieItemCommentId;
}
