package lab01;
import javax.swing.JOptionPane;
public class SolveEquations {
    public static void main(String[] args) {
        String[] options = {"First-degree univariable linear equation", "Systems of first-degree linear equations", "Quadratic equation"};
        int selection = JOptionPane.showOptionDialog(null, 
        "What do you want to solve?", "Types of equations", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        
        if (selection == 0) {
            firstUniLinear();
        }
        else if (selection == 1) {
            firstBiLinears();
        }
        else if (selection == 2) {
            quadratic();
        }

    }

    public static void firstUniLinear() {
        double a, b, c;
        String input = JOptionPane.showInputDialog(null, 
        "Please input the coefficients separated by spaces", "ax + b = c", JOptionPane.INFORMATION_MESSAGE);
        String[] stringArray = input.split(" ");
        a = Double.parseDouble(stringArray[0]);
        b = Double.parseDouble(stringArray[1]);
        c = Double.parseDouble(stringArray[2]);

        if (a == 0) {
            if (b != c) {
                JOptionPane.showMessageDialog(null, 
                "The equation has no solution!", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, 
                "The equation has infinitely many solutions!", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
        else {
            double sol = (c-b)/a;
            JOptionPane.showMessageDialog(null, 
            "The solution is: " + sol, "Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void firstBiLinears() {
        double a11, a12, a21, a22, b1, b2, x, y;
        String input1 = JOptionPane.showInputDialog(null, "Please input the coefficients separated by spaces for the first equation", "a11x + a12y = b1", JOptionPane.INFORMATION_MESSAGE);
        String[] stringArray1 = input1.split(" ");
        a11 = Double.parseDouble(stringArray1[0]);
        a12 = Double.parseDouble(stringArray1[1]);
        b1 = Double.parseDouble(stringArray1[2]);

        String input2 = JOptionPane.showInputDialog(null, "Please input the coefficients separated by spaces for the second equation", "a21x + a22y = b2", JOptionPane.INFORMATION_MESSAGE);
        String[] stringArray2 = input2.split(" ");
        a21 = Double.parseDouble(stringArray2[0]);
        a22 = Double.parseDouble(stringArray2[1]);
        b2 = Double.parseDouble(stringArray2[2]);

        double d = a11*a22 - a12*a21;
        double d1 = b1*a22 - b2*a12;
        double d2 = a11*b2 - a21*b1;

        if (d != 0) {
            x = d1/d;
            y = d2/d;
            JOptionPane.showMessageDialog(null, 
            "The solutions are: x = " + x + " and y = " + y , "Result", JOptionPane.INFORMATION_MESSAGE);
        }
        else if ((d == d1) & (d1 == d2) & (d == 0)) {
            JOptionPane.showMessageDialog(null, 
                "The system has infinitely many solutions!", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
        else if ((d == 0) & (d1 != 0) & (d2 != 0)) {
            JOptionPane.showMessageDialog(null, 
                "The system has no solutions!", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void quadratic() {
        double a, b, c;
        String input1 = JOptionPane.showInputDialog(null, "Please input the coefficients separated by spaces for the equation", "a(x^2) + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
        String[] stringArray1 = input1.split(" ");
        a = Double.parseDouble(stringArray1[0]);
        b = Double.parseDouble(stringArray1[1]);
        c = Double.parseDouble(stringArray1[2]);

        double delta = b*b - 4*a*c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta))/(2*a);
            double x2 = (-b - Math.sqrt(delta))/(2*a);
            JOptionPane.showMessageDialog(null, 
            "The solutions are: x1 = " + x1 + " and x2 = " + x2 , "Result", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (delta == 0) {
            double x = -b/(2*a);
            JOptionPane.showMessageDialog(null, 
            "The solutions are: x1 = x2 = " + x , "Result", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, 
                "The equation has no real solutions!", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}
