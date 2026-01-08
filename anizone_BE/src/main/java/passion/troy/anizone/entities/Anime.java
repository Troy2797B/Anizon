package passion.troy.anizone.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long animeId;

    @Column(nullable = false, unique = true)
    private Long externalId; //ID from external AnimeAPI

    @Column(nullable = false, unique = true, length = 255)
    private String title;

    @Column
    private Double averageStarRating; //This is optional. Consider computing via query instead.

    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> animeReviews = new ArrayList<>();
}
