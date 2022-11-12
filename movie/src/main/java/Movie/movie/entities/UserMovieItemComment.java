package Movie.movie.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_movie_item_comments")
@NoArgsConstructor
@AllArgsConstructor
public class UserMovieItemComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment_name")
    private String commentName;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User userId;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "movie_item_id")
    @JsonManagedReference
    private MovieItem movieItemId;

}
