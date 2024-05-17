package AimsProject.src.hust.soict.dsai.aims.cart;

import java.util.Arrays;

import AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20; 
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;

// Getters and Setters
    public int getQtyOrdered() {
        return this.qtyOrdered;
    }

    public DigitalVideoDisc[] getItemsOrdered() {
        return itemsOrdered;
    }

// Constructors
    public Cart(DigitalVideoDisc[] itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
        this.qtyOrdered = (int) Arrays.stream(itemsOrdered).filter(item -> item != null).count();
    }

    public Cart() {}

// Updating the qtyOrdered 
    public void updateQtyOrdered() {
        this.qtyOrdered = (int) Arrays.stream(this.itemsOrdered).filter(item -> item != null).count();
    }

// Adding DVDs to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("Your cart is full!!");
        }
        else {
            this.itemsOrdered[this.qtyOrdered] = disc;
            updateQtyOrdered();

            // System.out.println("The disc" + disc.getTitle() + " has been added!\n You can now add " + (20 - this.qtyOrdered) + " more DVDs.");
        }
        }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (this.qtyOrdered == MAX_NUMBERS_ORDERED | dvdList.length > MAX_NUMBERS_ORDERED - this.qtyOrdered) {
            System.out.println("Maximum number of orders exceeded!!");
        }
        else {
            for (int i = 0; i < dvdList.length; i++) {
                this.itemsOrdered[i+this.qtyOrdered] = dvdList[i];
            }
            updateQtyOrdered();
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (this.qtyOrdered >= MAX_NUMBERS_ORDERED - 1) {
            System.out.println("Maximum number of orders exceeded!!");
        }
        else {
            this.itemsOrdered[this.qtyOrdered] = dvd1;
            this.itemsOrdered[this.qtyOrdered + 1] = dvd2;
            updateQtyOrdered();
        }
    }

// Removing DVDs from the cart
        public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
            boolean check = false;
            for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
                if (this.itemsOrdered[i] == disc) {
                    this.itemsOrdered[i] = null;
                    check = true;
                    updateQtyOrdered();
                //     System.out.println("The disc " + disc.getTitle() + " has been removed!\n You can now add " + (20 - this.qtyOrdered) + " more DVDs.");
                }

                if (check == true & i != MAX_NUMBERS_ORDERED - 1) {
                    this.itemsOrdered[i] = this.itemsOrdered[i+1];
                    ;
                }
            }
        }

// Calculating the total cost
        public float totalCost() {
            float price = 0;
            for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
                if (this.itemsOrdered[i] != null) {
                    price += this.itemsOrdered[i].getCost();
                }
            }
            return price;
        }


// Printing out the list of ordered items of a cart
        public void print() {
            System.out.print(new String(new char[25]).replace("\0", "*"));
            // Repeat the "*" character 25 times.
            System.out.print("CART");
            System.out.print(new String(new char[25]).replace("\0", "*") + "\n");
            System.out.println("Ordered Items:");
            for (int i = 0; i < this.getQtyOrdered(); i++) {
                System.out.println(this.getItemsOrdered()[i].toString());
            }
            System.out.println(String.format("Total cost: %.2f$", this.totalCost()));
            System.out.println(new String(new char[54]).replace("\0", "*"));
        }

// Searching for DVDs
        public void searchDVD(int id) {
            boolean check = false;
            DigitalVideoDisc found = new DigitalVideoDisc();
            for (int i = 0; i < this.getQtyOrdered(); i++) {
                if (id == this.getItemsOrdered()[i].getId()) {
                    check = true;
                    found = this.getItemsOrdered()[i];
                } 
            }
            if (check == true) {
                System.out.println(found.toString());
            }
            else {System.out.println(String.format("No DVD in your cart has the ID %d!!", id));}
        }

        public void searchDVD(String title) {
            boolean check = false;
            DigitalVideoDisc found = new DigitalVideoDisc();
            String lowerTitle = title.toLowerCase();
            for (int i = 0; i < this.getQtyOrdered(); i++) {
                if (this.getItemsOrdered()[i].getTitle().toLowerCase().contains(lowerTitle)) {
                    check = true;
                    found = this.getItemsOrdered()[i];
                } 
            }
            if (check == true) {
                System.out.println(found.toString());
            }
            else {System.out.println(String.format("No DVD in your cart has the title '%s'!!", title));}
        }
}
    

