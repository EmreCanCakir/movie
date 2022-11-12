package Movie.movie.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "links")
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "size")
    private String size;

    @Column(name = "link_address", nullable = false)
    private String linkAddress;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "movie_item_id")
    @JsonManagedReference
    private MovieItem movieItemId;

}
