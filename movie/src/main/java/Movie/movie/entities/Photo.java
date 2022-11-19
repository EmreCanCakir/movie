package Movie.movie.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "photos")
@NoArgsConstructor
@AllArgsConstructor
public class Photo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Lob
    @Column(name = "data")
    private byte[] data;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "movie_id")
    @JsonManagedReference
    private Movie movieId;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "user_movie_item_command_id")
    @JsonManagedReference
    private UserMovieItemComment userMovieItemCommentId;
}
