package Movie.movie.entities.dtos;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class MovieDto {
    private int id;

    private String title;

    private String subject;

    private Date year;

    private String country;

    private String language;

    private int time;

    private String rating;

    private String released;

    private LocalDateTime createdAt;

    private LocalDateTime lastModifiedAt;
}
