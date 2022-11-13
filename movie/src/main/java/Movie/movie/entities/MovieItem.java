package Movie.movie.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "movie_items")
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class MovieItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;

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

    @Column(name = "created_at",nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;

}
