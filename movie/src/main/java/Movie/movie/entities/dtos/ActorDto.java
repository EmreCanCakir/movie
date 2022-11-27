package Movie.movie.entities.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class ActorDto {

    private String firstName;

    private String lastName;

    private Date birthDate;

    private String homeland;

    private char gender;
}
