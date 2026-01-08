package passion.troy.anizone.entities;

import jakarta.persistence.*;
import lombok.*;
import passion.troy.anizone.Platform;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table (name = "streamingPlatform")
public class StreamingPlatform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long platformId;

    @Column(nullable = false, unique = true)
    private String platformName;

    @ManyToMany(mappedBy = "subscribedStreamingPlatforms")
    private Set<Account> accountsByPlatform = new LinkedHashSet<>();

    public StreamingPlatform(Long platformId, String platformName) {
        this.platformName = platformName;
        this.platformId = platformId;
    }

}
