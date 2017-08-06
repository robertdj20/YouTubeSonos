package youtubesonos;

public enum IdPrefix {
    CHANNEL("CH"),
    VIDEO("VI"),
    PLAYLIST("PL"),
    CHANNELPLAYLISTS("CP");

    private final String value;

    IdPrefix(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
