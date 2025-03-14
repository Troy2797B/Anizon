package passion.troy.anizone;

public enum Platforms {
    HULU("Hulu"),
    NETFLIX("Netflix"),
    DISNEY_PLUS("Disney Plus"),
    AMAZON_PRIME("Amazon Prime"),
    HBO_MAX("HBO Max"),
    APPLE_TV("Apple TV"),
    PEACOCK("Peacock"),
    PARAMOUNT_PLUS("Paramount Plus");

    private final String name;

    Platforms (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
