package Movie.movie.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "movie_direction")
@NoArgsConstructor
@AllArgsConstructor
public class MovieDirection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "movie_item_id")
    @JsonManagedReference
    private MovieItem movieItemId;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "director_id")
    @JsonManagedReference
    private Director directorId;
}
