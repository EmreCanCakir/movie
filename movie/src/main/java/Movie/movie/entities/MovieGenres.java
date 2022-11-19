package Movie.movie.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "movie_genres")
@NoArgsConstructor
@AllArgsConstructor
public class MovieGenres {

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
    @JoinColumn(name = "genre_id")
    @JsonManagedReference
    private Genre genreId;
}
