package Movie.movie.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)       //This provides to keep lastModifiedDate and creationTimeStamp values in [];
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "year", nullable = false)
    private Date year;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "time")
    private int time;

    @Column(name = "rating")
    private String rating;

    @OneToOne(mappedBy = "movie")
    private MovieItem movieItemId;

    @Column(name = "created_at",nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;
}
