package OtherProjects.lab1;
import javax.swing.JOptionPane;
public class Triangle {
    public static void main(String[] args) {
        String strNum = JOptionPane.showInputDialog(null, "Enter the height of the triangle: ", JOptionPane.INFORMATION_MESSAGE);
        int n = Integer.parseInt(strNum);
        triange(n);
    }
    public static void triange(int n) {
        String character = "*";
        for (int j = 1; j <= n; j++) {
            repeat(" ", n-j);
            repeat(character, 2*j - 1);
            System.out.println();
        }
    }
    public static void repeat(String x, int n) {
        if (n == 0) {}
        else {
            for (int i = 1; i <= n; i++) {
                System.out.print(x);
            }
        }
        
    }
}
