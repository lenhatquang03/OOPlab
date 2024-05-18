package hust.soict.dsai.aims.media;

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

    // Methods
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
}
