import java.util.LinkedList;

public class Playlist {
    private LinkedList<Song> playlist;

    Playlist() {
        playlist = new LinkedList<>();
    }

    public boolean addToPlaylist(Album album, Song song) {
        if (album.foundInAlbum(song)) {
            return playlist.add(song);
        }
        return false;
    }

    public LinkedList<Song> getPlaylist() {
        return playlist;
    }

}