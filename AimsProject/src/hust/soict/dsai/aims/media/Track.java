package hust.soict.dsai.aims.media;

import java.util.Objects;

public class Track implements Playable {
    // Attributes
    private String title;
    private int length;

    // Accessors
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    // Constructor
    public Track(int length) {
        this.length = length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Methods
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track track = (Track) obj;
            return Objects.equals(this.title, track.title) && Objects.equals(this.length, track.length);
        }
        return false;
    }
}
