
package passion.troy.anizone.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "account") // avoid reserved word
public class Account {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long accountId; //Use as foreign key to reference reviews
    @Column(nullable = false, unique = true, length = 255)
    @Email
    private String email;

    @Column(nullable = false, length = 50)
    private String accountName;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList <Review> accountReviews = new ArrayList<>();

    @Column (nullable = false)
    private Boolean prefersSub;

    @Column (nullable = false)
    private Boolean prefersDub;

    @ManyToMany
    @JoinTable(
            name = "watched_anime",
            joinColumns = @JoinColumn(name = "accountId"),
            inverseJoinColumns = @JoinColumn(name = "animeId"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"accountId", "animeId"})
    )
    private Set<Anime> watchedAnime = new LinkedHashSet<>();


    @ManyToMany
    @JoinTable(
            name = "subscribed_streaming_platforms",
            joinColumns = @JoinColumn(name = "accountId"),
            inverseJoinColumns = @JoinColumn(name = "platformId"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"accountId", "platformId"})
    )
    private Set<StreamingPlatform> subscribedStreamingPlatforms = new LinkedHashSet<>();

    public Account() {
    }

    public Account(Long accountID, String accountName) {
        this.accountId = accountID;
        this.accountName = accountName;
    }

    public Account(Boolean prefersDub, Boolean prefersSub, String accountName, String email) {
        this.accountName = accountName;
        this.email = email;
        this.prefersDub = prefersDub;
        this.prefersSub = prefersSub;
    }
}
