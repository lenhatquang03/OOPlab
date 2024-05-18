package hust.soict.dsai.aims.media;

public class Disc extends Media {
    // Attributes
    private int length;
    private String director;

    // Accessors
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Constructor
    public Disc() {}

    public Disc(String title, String category, String director, int length) {
        super(title, category);
        this.director = director;
        this.length = length;
    }


}
