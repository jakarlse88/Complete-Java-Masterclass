import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private int year;
    private SongList songs;

    Album(String name, String artist, int year) {
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.songs = new SongList();
    }

    void addToAlbum(Song song) {

        this.songs.addSong(song);
    }

    boolean foundInAlbum(Song song) {
        return this.songs.foundSong(song.getSongName()) != null;
    }

    private class SongList {
        private List<Song> songs;

        SongList() {
            songs = new ArrayList<>();
        }

        public boolean addSong(Song song) {
            if (songs.contains(song)) {
                return false;
            } else {
                return !songs.isEmpty() && song != null && songs.add(song);
            }
        }

        private Song foundSong(String title) {
            for (Song checkedSong : this.songs) {
                if (checkedSong.getSongName().equals(title)) {
                    return checkedSong;
                }
            }
            return null;
        }

        private Song foundSong(int trackNumber) {
            int index = trackNumber - 1;
            if ((index > 0) && (index < this.songs.size())) {
                return songs.get(index);
            }
            return null;
        }
    }
}