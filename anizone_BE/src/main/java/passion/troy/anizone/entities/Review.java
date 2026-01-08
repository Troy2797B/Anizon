package passion.troy.anizone.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)//Many reviews can be written by one user
    @JoinColumn(name = "userId", nullable = false)
    private Account account; //Foreign key to reference// User

    @ManyToOne //Many reviews can be written for one anime
    @JoinColumn(name = "animeId", nullable = false)
    private Anime anime; //Foreign key to reference Anime

    @Column(name = "reviewText", nullable = false, length = 5000)
    private String reviewText;

    @Min(
        value = 1,
        message = "Star rating must be at least 1"
    )
    @Max(
        value = 5,
        message = "Star rating cannot be more than 5"
    )
    @Column(nullable = false)
    private Integer starRating; //1-5 scale

    @Column(nullable = false)
    private Boolean isSpoiler;
}
