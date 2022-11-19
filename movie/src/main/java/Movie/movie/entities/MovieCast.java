package Movie.movie.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "movie_cast")
@NoArgsConstructor
@AllArgsConstructor
public class MovieCast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "movie_id")
    @JsonManagedReference
    private Movie movieId;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "actor_id")
    @JsonManagedReference
    private Actor actorId;

    @Column(name = "role")
    private String role;
}
