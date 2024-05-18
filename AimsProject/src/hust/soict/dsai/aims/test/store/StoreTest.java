package hust.soict.dsai.aims.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store myStore = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc();
        DigitalVideoDisc[] aDVDs = {dvd1, dvd2, dvd3};
        myStore.addMedia(aDVDs);
        
        System.out.println("List of DVDs in store after adding some: ");
        for (int i = 0; i < myStore.getItemsInStore().size(); i++) {
            System.out.println(myStore.getItemsInStore().get(i).toString());
        }

        System.out.println();
        DigitalVideoDisc[] rDVDs = {dvd2, dvd4};
        myStore.removeMedia(rDVDs);
        System.out.println("List of DVDs in store after removing some: ");
        for (int i = 0; i < myStore.getItemsInStore().size(); i++) {
            System.out.println(myStore.getItemsInStore().get(i).toString());
        }      
    } 
}
