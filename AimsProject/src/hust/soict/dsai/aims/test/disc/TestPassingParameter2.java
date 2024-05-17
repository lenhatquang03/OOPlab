package AimsProject.src.hust.soict.dsai.aims.test.disc;

import AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter2 {
	public static void main(String[] args) {

		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

		swap(jungleDVD, cinderellaDVD);
		// The arguments jungleDVD and cinderellaDVD are copies of the "real" reference variables pointing to the 2 objects jungleDVD and cinderellaDVD respectively. As a result, the 2 copies are swapped, not the real reference variables.

		 System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		 System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

		 changeTitle(jungleDVD, cinderellaDVD.getTitle());
		 /* Again, the argument jungleDVD is a copy of the "real" reference variable pointing to the object jungleDVD. It's good to remember that an object can have several reference variables. The setter method for the attribute "title" when called from any reference variable will change the attribute of the real object. 
		  * Afterwards, this copied "jungleDVD" reference variable is pointed to a new object. Still, the original reference variable points to the original object (which has been modified)
		 */
		 System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}

	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}

	 public static void changeTitle(DigitalVideoDisc dvd, String title) {
	 	String oldTitle = dvd.getTitle();
	 	dvd.setTitle(title);
	 	dvd = new DigitalVideoDisc(oldTitle);
	 }


}
