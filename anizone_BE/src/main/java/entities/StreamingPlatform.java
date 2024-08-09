package entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name= "streaming_platform")
public class StreamingPlatform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long platformId;
    @Column(name = "sp_name")
    private String name;

    private Map<String, Set<User>> usersByPlatform;

    public StreamingPlatform(){

    }
    public StreamingPlatform(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Set<User>> getUsersByPlatform() {
        return usersByPlatform;
    }

    public void setUsersByPlatform(Map<String, Set<User>> usersByPlatform) {
        this.usersByPlatform = usersByPlatform;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreamingPlatform that = (StreamingPlatform) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(usersByPlatform, that.usersByPlatform);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, usersByPlatform);
    }
}
