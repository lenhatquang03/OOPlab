package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart an0der = new Cart();

        // Adding DVDs into the Cart

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        an0der.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        an0der.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        an0der.addDigitalVideoDisc(dvd3);
         
         an0der.addDigitalVideoDisc(new DigitalVideoDisc("A"), new DigitalVideoDisc("B"));

//         for (int i = 0; i < an0der.getItemsOrdered().length; i++) {
//             System.out.println(an0der.getItemsOrdered()[i]);
//         }
//
//         an0der.removeDigitalVideoDisc(dvd3);
//
//         for (int i = 0; i < an0der.getItemsOrdered().length; i++) {
//             System.out.println(an0der.getItemsOrdered()[i]);
//         }
//
//         System.out.println("There're " + an0der.getQtyOrdered() + " DVDs in your cart.");
//
//         System.out.println("The total cost is: " + String.format("%2.2f", an0der.totalCost()));
    }
}
