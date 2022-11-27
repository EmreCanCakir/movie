package Movie.movie.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDto {
    private int id;
    private String size;
    private String linkAddress;
    private int MovieItemId;
}
