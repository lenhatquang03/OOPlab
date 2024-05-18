package hust.soict.dsai.aims.media;

public class Track {
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
}
