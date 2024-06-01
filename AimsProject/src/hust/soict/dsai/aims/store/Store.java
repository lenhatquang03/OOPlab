package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {

    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public Store() {}

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void setItemsInStore(ArrayList<Media> itemsInStore) {
        this.itemsInStore = itemsInStore;
    }

    public void addMedia(Media[] productList) {
        for (Media product: productList) {
            if (this.itemsInStore.contains(product)) {
                System.out.println(product.getTitle() + " is already in the store!");
            }
            else {
                this.itemsInStore.add(product);
            }
        }
    }

    public void removeMedia(Media[] productList) {
        for (Media product: productList) {
            if (!this.itemsInStore.contains(product)) {
                System.out.println(product.getTitle() + " is not in the store!");
            }
            else {
                this.itemsInStore.remove(product);
            }
        }
    }
}
