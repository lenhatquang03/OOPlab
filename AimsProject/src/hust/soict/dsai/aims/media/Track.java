package AimsProject.src.hust.soict.dsai.aims.media;

public class Track {
    // Attributes
    private String title;
    private int length;

    // Accessor methods
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    // Constructors
    public Track() {}
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
}
