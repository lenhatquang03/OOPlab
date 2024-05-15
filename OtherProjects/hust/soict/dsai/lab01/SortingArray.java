package lab01;
import javax.swing.JOptionPane;
import java.util.Arrays;
public class SortingArray {
    public static void main(String[] args) {
        String strSize = JOptionPane.showInputDialog(null, "Enter your array's size: ", "Size", JOptionPane.INFORMATION_MESSAGE);
        int size = Integer.parseInt(strSize);

        int[] arr = new int[size];
        
        String input = JOptionPane.showInputDialog(null, "Enter the elements of your array (separated by spaces): ", JOptionPane.INFORMATION_MESSAGE);
        String[] strArr = input.split(" ");

        if (strArr.length != size) {
            JOptionPane.showMessageDialog(null, "Number of elements exceeded", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else {
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }
        }
        Arrays.sort(arr);
        String display = Arrays.toString(arr);
        System.out.println("The sorted arrray is: " + display);
        System.out.println("The sum of all array elements is: " + sum(arr));
        System.out.println("The average value of all array elements is " + average(arr));
    }
    public static int sum(int[] array) {
        int s = 0;
        for (int i = 0; i < array.length; i++) {
            s += array[i];
        }
        return s;
    }
    public static double average(int[] arr) {
        double average;
        double dsum = sum(arr);
        double dsize = arr.length;
        average = dsum/dsize;
        return average;
    }
}