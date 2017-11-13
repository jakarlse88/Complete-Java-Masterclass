import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album wintersun = new Album("The Forest Seasons", "Wintersun", 2017);

            Song one = new Song("Awaken From the Dark Slumber (Spring)", (float) 14.40);
            wintersun.addToAlbum(one);

            Song two = new Song("The Forest that Weeps (Summer)", (float) 12.18);
            wintersun.addToAlbum(two);

            Song three = new Song("Eternal Darkness (Autumn)", (float) 14.08);
            wintersun.addToAlbum(three);

            Song four = new Song("Loneliness (Winter)", (float) 12.54);
            wintersun.addToAlbum(four);

        Playlist playlist = new Playlist();
            addToPlaylist(playlist.getPlaylist(), four);
            addToPlaylist(playlist.getPlaylist(), three);
            addToPlaylist(playlist.getPlaylist(), two);
            addToPlaylist(playlist.getPlaylist(), one);

        play(playlist.getPlaylist());
    }

    private static void addToPlaylist(LinkedList<Song> playlist, Song song) {
        ListIterator<Song> playlistIterator = playlist.listIterator();
        playlistIterator.add(song);
    }

    private static void printPlaylist(LinkedList<Song> playlist) {
        ListIterator<Song> playlistIterator = playlist.listIterator();
        while (playlistIterator.hasNext()) {
            System.out.println("Current song: " + playlistIterator.next().getSongName());
        }
        System.out.println("===================");
    }

    private static void printMenu() {
        System.out.println("Menu options: \n" +
                            "1 - Quit\n" +
                            "2 - Skip forward to next song\n" +
                            "3 - Skip backward to previous song\n" +
                            "4 - Replay current song\n");
    }

    private static void play(LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        boolean goingForward = true;

        ListIterator<Song> playlistIterator = playlist.listIterator();

        if (playlist.isEmpty()) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing: " + playlistIterator.next().getSongName());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 1:
                    System.out.println("Quitting player.");
                    quit = true;
                    break;
                case 2:
                    if (!goingForward) {
                        if (playlistIterator.hasNext()) {
                            playlistIterator.next();
                        }
                        goingForward = true;
                    }
                    if (playlistIterator.hasNext()) {
                        System.out.println("Now playing: " + playlistIterator.next().getSongName());
                    } else {
                        System.out.println("End of playlist reached.");
                        goingForward = false;
                    }
                    break;
                case 3:
                    if (goingForward) {
                        if (playlistIterator.hasPrevious()) {
                            playlistIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (playlistIterator.hasPrevious()) {
                        System.out.println("Now playing: " + playlistIterator.previous().getSongName());
                    } else {
                        System.out.println("Beginning of playlist reached.");
                        goingForward = true;
                    }
                    break;
                case 4:
                    if (goingForward) {
                        if (playlistIterator.hasPrevious()) {
                            System.out.println("Now replaying: " + playlistIterator.previous().getSongName());
                            goingForward = false;
                        } else {
                            System.out.println("End of playlist reached.");
                        }
                    } else if (!goingForward) {
                        if (playlistIterator.hasNext()) {
                            System.out.println("Now replaying: " + playlistIterator.next().getSongName());
                            goingForward = true;
                        } else {
                            System.out.println("Beginning of playlist reached.");
                        }
                    break;
                }
            }
        }
    }
}
