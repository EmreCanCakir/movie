package Movie.movie.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "actors")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birth_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date birthDate;

    @Column(name = "homeland")
    private String homeland;

    @Column(name = "gender")
    private char gender;

    @OneToMany(mappedBy = "actorId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MovieCast> movieCasts;
}
