package AimsProject.src.hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
    // Attributes
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();

    // Accessor methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
