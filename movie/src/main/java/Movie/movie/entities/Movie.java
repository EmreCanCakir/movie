package Movie.movie.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
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

    @Column(name = "released")
    private String released;

    @OneToOne(mappedBy = "movie")
    @JsonIgnore
    private MovieItem movieItemId;

    @Column(name = "created_at",nullable = false,updatable = false)
    @CreationTimestamp
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastModifiedAt;

    @OneToMany(mappedBy = "movieId")
    private List<MovieGenres> movieGenres;

    @OneToMany(mappedBy = "movieId")
    private List<MovieDirection> movieDirections;

    @OneToMany(mappedBy = "movieId")
    private List<MovieCast> movieCasts;

    @OneToMany(mappedBy = "movieId")
    private List<Photo> photos;
}
