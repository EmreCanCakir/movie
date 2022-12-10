package Movie.movie.entities.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserDto implements Serializable {
    private int id;
    private String email;
    private String password;
    private String userName;
    private String userType;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
}
