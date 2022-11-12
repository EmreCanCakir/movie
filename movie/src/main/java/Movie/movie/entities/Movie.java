package Movie.movie.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
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
}
