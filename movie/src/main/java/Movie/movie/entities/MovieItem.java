package Movie.movie.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "movie_items")
@NoArgsConstructor
@AllArgsConstructor
public class MovieItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private Movie movie;

    @OneToMany(mappedBy = "movieItemId")
    @JsonBackReference
    private List<Photo> photos;

    @OneToMany(mappedBy = "movieItemId")
    @JsonBackReference
    private List<MovieGenres> movieGenres;

    @OneToMany(mappedBy = "movieItemId")
    @JsonBackReference
    private List<MovieDirection> movieDirections;

    @OneToMany(mappedBy = "movieItemId")
    @JsonBackReference
    private List<MovieCast> movieCasts;

    @OneToMany(mappedBy = "movieItemId")
    @JsonBackReference
    private List<Link> links;

    @OneToMany(mappedBy = "movieItemId")
    @JsonBackReference
    private List<UserMovieItemComment> userMovieItemComments;
}
