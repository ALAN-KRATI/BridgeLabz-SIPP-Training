class Song {
    String title;
    String artist;
    int duration; // seconds
    Song next;

    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.next = null;
    }
}

public class MusicPlaylist {
    Song head = null;

    public void addSong(String title, String artist, int duration) {
        Song newSong = new Song(title, artist, duration);
        if (head == null) {
            head = newSong;
            newSong.next = head;
            return;
        }
        Song temp = head;
        while (temp.next != head)
            temp = temp.next;
        temp.next = newSong;
        newSong.next = head;
    }

    public void playNext() {
        if (head == null) {
            System.out.println("No songs.");
            return;
        }
        System.out.println("Now Playing: " + head.title + " by " + head.artist);
        head = head.next;
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist empty.");
            return;
        }
        Song temp = head;
        do {
            System.out.println(temp.title + " - " + temp.artist + " (" + temp.duration + "s)");
            temp = temp.next;
        } while (temp != head);
    }

    public void removeSong(String title) {
        if (head == null) return;
        if (head.title.equals(title) && head.next == head) {
            head = null;
            return;
        }
        Song temp = head, prev = null;
        do {
            if (temp.title.equals(title)) {
                if (temp == head) {
                    Song last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        MusicPlaylist mp = new MusicPlaylist();
        mp.addSong("Kesariya", "Arijit", 210);
        mp.addSong("Ghungroo", "Arijit", 200);
        mp.addSong("Tum Mile", "KK", 240);
        mp.displayPlaylist();
        mp.playNext();
        mp.removeSong("Kesariya");
        mp.displayPlaylist();
    }
}
