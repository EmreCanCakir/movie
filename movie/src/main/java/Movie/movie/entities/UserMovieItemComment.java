package Movie.movie.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "user_movie_item_comments")
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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

    @Column(name = "created_at",nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;

    @OneToMany(mappedBy = "userMovieItemCommentId")
    @JsonBackReference
    private List<Photo> photos;
}
