public class Song {
    private String name;
    private float duration;

    public Song(String name, float duration) {
        this.name = name;
        this.duration = duration;
    }

    public Song getSong() {
        return this;
    }

    public String getSongName() {
        return this.name;
    }
}