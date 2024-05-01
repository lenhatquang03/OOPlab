package lab01;
import javax.swing.JOptionPane;
public class Calculate {
    public static void main(String[] args) {
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null, 
        "Please inpur the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, 
        "Please inpur the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        sum(num1, num2);
        difference(num1, num2);
        product(num1, num2);
        quotient(num1, num2);

    }
    public static void sum(double a, double b) {
        double s = a + b;
        JOptionPane.showMessageDialog(null, 
        "The sum of two numbers is: " + s, "Sum", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void difference(double a, double b) {
        double diff = a - b;
        JOptionPane.showMessageDialog(null, 
        "The difference of two numbers is: " + diff, "Difference", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void product(double a, double b) {
        double p = a*b;
        JOptionPane.showMessageDialog(null, 
        "The product of two numbers is: " + p, "Product", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void quotient(double a, double b) {
        if (b != 0) {
            double q = a/b;
            JOptionPane.showMessageDialog(null, 
            "The quotient of two numbers is: " + q, "Quotient", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, 
            "ZeroDivisionError:division by zero", "Error warning!", JOptionPane.ERROR_MESSAGE);
        }
    }

}
