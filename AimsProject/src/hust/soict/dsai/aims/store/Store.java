package AimsProject.src.hust.soict.dsai.aims.store;

import java.util.*;

import AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;
public class Store {
    private DigitalVideoDisc[] itemsInStore;

    public DigitalVideoDisc[] getItemsInStore() {
        return itemsInStore;
    }

    public void setItemsInStore(DigitalVideoDisc[] itemsInStore) {
        this.itemsInStore = itemsInStore;
    }

    public void addDVD(DigitalVideoDisc[] DVDs) {
        List<DigitalVideoDisc> lst = new ArrayList<>();
        Collections.addAll(lst, DVDs);
        DigitalVideoDisc[] updateItems = new DigitalVideoDisc[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            updateItems[i] = lst.get(i);
        }
        this.setItemsInStore(updateItems);
        System.out.println("All DVDs have been successfully added!!");
    }

    public void removeDVD(DigitalVideoDisc[] DVDs) {
        List<DigitalVideoDisc> currentLst = new ArrayList<DigitalVideoDisc>(Arrays.asList(this.getItemsInStore()));

        for (DigitalVideoDisc dvd: DVDs) {
            if (currentLst.contains(dvd)) {
                currentLst.remove(dvd);
                System.out.println(dvd.toString() + " HAS BEEN REMOVED!");
            }
        }
        DigitalVideoDisc[] updateItems = new DigitalVideoDisc[currentLst.size()];
        for (int i = 0; i < currentLst.size(); i++) {
            updateItems[i] = currentLst.get(i);
        }
        this.setItemsInStore(updateItems);
    }
}
