package Movie.movie.entities.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserDto implements Serializable {
    private final String email;
    private final String password;
    private final String userName;
    private final String userType;
    private final LocalDateTime createdAt;
    private final LocalDateTime lastModifiedAt;
}
