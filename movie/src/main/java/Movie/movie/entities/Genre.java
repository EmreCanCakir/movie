package Movie.movie.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "genres")
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "genre_name", nullable = false, unique = true)
    private String genreName;

    @OneToMany(mappedBy = "genreId")
    @JsonBackReference
    private List<MovieGenres> movieGenres;
}
