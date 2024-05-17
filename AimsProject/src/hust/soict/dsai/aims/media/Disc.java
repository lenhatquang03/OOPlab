package AimsProject.src.hust.soict.dsai.aims.media;

public class Disc extends Media{
    // Attributes
    private int length;
    private String director;

    // Accessor methods
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    // Constructors
    public Disc() {}

    public Disc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public Disc(String title, String director) {
        super(title);
        this.director = director;
    }
}
