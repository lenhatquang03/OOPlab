package lab01;
import javax.swing.JOptionPane;
public class HelloNameDialog {
    public static void main(String[] args) {
        String result;
        result = JOptionPane.showInputDialog("Le Nhat Quang 5522 - Please enter your name:");
        JOptionPane.showMessageDialog(null,"Toi la Le Nhat Quang 5522. Hi" + result + "!");
        System.exit(0);
    }
    
}
