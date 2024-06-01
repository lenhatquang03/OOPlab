package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

// Constructors
    public Cart(ArrayList<Media> itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    // Acessor methods
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public Cart() {}

    // Adding products
    public void addMedia(Media product) {
        if (this.itemsOrdered.size() == Cart.MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full!");
        }
        if (this.itemsOrdered.contains(product)) {
            System.out.println("Product is already in the cart!");
        }
        else {
            this.itemsOrdered.add(product);
        }
    }

    public void addMedia(Media[] productList) {
        if (productList.length > Cart.MAX_NUMBERS_ORDERED - this.itemsOrdered.size()) {
            {System.out.println("The number of products in cart is limited! Can't add all products.");}
        }
        else {
            for (Media product : productList) {
                this.itemsOrdered.add(product);
            }
        }
    }

    public void addMedia(Media product1, Media product2) {
        if (this.itemsOrdered.size() >= Cart.MAX_NUMBERS_ORDERED - 1) {
            System.out.println("The number of products in cart is limited! Can't add all products.");
        }
        else {
            this.itemsOrdered.add(product1);
            this.itemsOrdered.add(product2);
        }
    }

    // Removing a product
    public void removeMedia(Media product) {
        if (this.itemsOrdered.contains(product)) {
            this.itemsOrdered.remove(product);
        }
        else {
            System.out.println("The product is not in the cart!");
        }
    }

// Calculating the total cost
        public float totalCost() {
            float price = 0;
            for (int i = 0; i < this.itemsOrdered.size(); i++) {
                price += this.itemsOrdered.get(i).getCost();
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
            for (int i = 0; i < this.itemsOrdered.size(); i++) {
                System.out.println(this.itemsOrdered.get(i).toString());
            }
            System.out.println(String.format("Total cost: %.2f$", this.totalCost()));
            System.out.println(new String(new char[54]).replace("\0", "*"));
        }

// Searching for DVDs
        public void searchDVD(int id) {
            boolean check = false;
            Object found = new Object();
            for (int i = 0; i < this.itemsOrdered.size(); i++) {
                if (id == this.itemsOrdered.get(i).getId()) {
                    check = true;
                    found = this.itemsOrdered.get(i);
                } 
            }
            if (check) {
                System.out.println(found.toString());
            }
            else {System.out.println(String.format("No DVD in your cart has the ID %d!!", id));}
        }

        public void searchDVD(String title) {
            boolean check = false;
            Object found = new Object();
            String lowerTitle = title.toLowerCase();
            for (int i = 0; i < this.itemsOrdered.size(); i++) {
                if (this.itemsOrdered.get(i).getTitle().toLowerCase().contains(lowerTitle)) {
                    check = true;
                    found = this.itemsOrdered.get(i);
                } 
            }
            if (check) {
                System.out.println(found.toString());
            }
            else {System.out.println(String.format("No DVD in your cart has the title '%s'!!", title));}
        }
}
    

