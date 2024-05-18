package hust.soict.dsai.aims.media;

import java.util.Objects;

public abstract class Media {
    // Attributes
    private int id;
    private String title;
    private String category;
    private float cost;

    // Accessor methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    // Constructors
    public Media(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public Media() {}

    public Media(String title) {
        this.title = title;
    }

    // Methods
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Media) {
            Media media = (Media) obj;
            return Objects.equals(this.title, media.title);
        }
        return false;
    }
}
