package AimsProject.src.hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
    // Attributes
    private List<String> authors = new ArrayList<String>();

    // Constructor
    public Book() {}

    // Methods
    public void addAuthor(String authorName) {
        if (this.authors.contains(authorName)) {
            System.out.println("The author already exists!");
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
            System.out.println("The author does not exist!");
        }
    }
}
