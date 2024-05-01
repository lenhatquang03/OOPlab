package OtherProjects.lab1;
import javax.swing.JOptionPane;
public class MatrixAddition {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(null, "Enter the matrixes' size (row, column): ", "Size", JOptionPane.INFORMATION_MESSAGE);
        String[] strSize = input.split(" ");
        int[] size = new int[2];
        size[0] = Integer.parseInt(strSize[0]);
        size[1] = Integer.parseInt(strSize[1]);

         
        String[][] strMatrix1 = new String[size[0]][size[1]];
        JOptionPane.showMessageDialog(null, "Enter the entries for the first matrix!");
        for (int i = 0; i < size[0]; i++) {
            String input1 = JOptionPane.showInputDialog(null, "Enter row " + (i+1) + " of the first matrix");
            strMatrix1[i] = input1.split(" ");
        }

        String[][] strMatrix2 = new String[size[0]][size[1]];
        JOptionPane.showMessageDialog(null, "Enter the entries for the second matrix!");
        for (int i = 0; i < size[0]; i++) {
            String input2 = JOptionPane.showInputDialog(null, "Enter row " + (i+1) + " of the second matrix");
            strMatrix2[i] = input2.split(" ");
        }
        
        double[][] matrix1 = new double[size[0]][size[1]];
        double[][] matrix2 = new double[size[0]][size[1]];
        double[][] sumMatrix = new double[size[0]][size[1]];

        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                matrix1[i][j] = Double.parseDouble(strMatrix1[i][j]);
                matrix2[i][j] = Double.parseDouble(strMatrix2[i][j]);
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("The first matrix: ");
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("The second matrix: ");
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("The sum matrix:");
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}