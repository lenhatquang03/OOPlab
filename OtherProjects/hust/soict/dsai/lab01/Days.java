package lab01;
import java.util.Arrays;
import javax.swing.JOptionPane;
public class Days {
    public static void main(String[] args) {
        String strYear, strMonth;
        strYear = JOptionPane.showInputDialog(null, "Enter the year:", "Year", JOptionPane.INFORMATION_MESSAGE);
        strMonth = JOptionPane.showInputDialog(null, "Enter the month:", "Month", JOptionPane.INFORMATION_MESSAGE);

        int monthIndex, check;
        check = 0;
        monthIndex = 0;
        int year = Integer.parseInt(strYear);
        String[][] monthInputs = {{"January","Jan.", "Jan", "1"}, {"February", "Feb.", "Feb", "2"}, {"March", "Mar.", "Mar", "3"}, 
        {"April", "Apr.", "Apr", "4"}, {"May", "5"}, {"June", "Jun", "6"}, {"July", "Jul", "7"},
         {"August", "Aug.", "Aug", "8"}, {"September", "Sept.", "Sep", "9"}, {"October", "Oct.", "Oct", "10"}, {"November", "Nov.", "Nov", "11"}, {"December", "Dec.", "Dec", "12"}};

        for (int i = 0; i < monthInputs.length; i++) {
            if (Arrays.asList(monthInputs[i]).contains(strMonth) == true) {
                monthIndex += (i+1);
                check += 1;
            }
            else {}
        }
        if (check == 0) {
            JOptionPane.showInputDialog(null, "Please enter the month again!", "SyntaxError for months", JOptionPane.WARNING_MESSAGE);
        }
        String[] same30 = {"4", "6", "9", "11"};
        String[] same31 = {"1", "3", "5", "7", "8", "10", "12"};
        if (Arrays.asList(same30).contains(String.valueOf(monthIndex))) {
            JOptionPane.showMessageDialog(null, "The number of days is: " + 30, "Days", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (Arrays.asList(same31).contains(String.valueOf(monthIndex))) {
            JOptionPane.showMessageDialog(null, "The number of days is: " + 31, "Days", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (monthIndex == 2) {
            if ((year % 4 != 0) || ((year%100 == 0) & (year % 400 != 0))) {
                JOptionPane.showMessageDialog(null, "The number of days is: " + 28, "Days", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (year % 400 == 0) {
                JOptionPane.showMessageDialog(null, "The number of days is: " + 29, "Days", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
