package hust.soict.dsai.aims.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.Collections;

public class CartTest {

    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Lion King", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
        for (Media media: cart.getItemsOrdered()) {
            System.out.println(media);
        }

//        System.out.println("Search results for \"lion\": ");
//        cart.searchDVD("lion");
        

    }
    


    
}
