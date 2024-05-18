package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    // Attributes
    private List<String> authors = new ArrayList<String>();

    // Constructor
    public Book() {}

    // Accessor methods

    // Methods
    public void addAuthor(String authorName) {
        if (this.authors.contains(authorName)) {
            System.out.println("The author already exists!!");
        }
        else {
            this.authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (this.authors.contains(authorName)) {
            this.authors.remove(authorName);
        }
        else {
            System.out.println("The author does not exist!!");
        }
    }
}
