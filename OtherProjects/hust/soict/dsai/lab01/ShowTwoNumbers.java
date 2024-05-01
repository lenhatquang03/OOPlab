package lab01;
import javax.swing.JOptionPane;
public class ShowTwoNumbers {
	public static void main(String[] args) {
		String strNum1, strNum2;
		String strNotification = "You've just entered: ";
		
		strNum1 = JOptionPane.showInputDialog(null, 
				"Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
		strNotification += strNum1 + " and ";
        // INFORMATION_MESSAGE is one the message styles. The Look and Feel manager may lay out the dialog differently depending on this value, and will often provide a default icon.
		
		strNum2 = JOptionPane.showInputDialog(null, 
				"Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
		strNotification += strNum2;
		
		JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
