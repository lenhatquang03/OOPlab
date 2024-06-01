package hust.soict.dsai.swing;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAccumulator extends Frame{
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0; // Accumulated sum, init to 0

    // Constructor to setup the GUI components and event handlers
    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2)); // Layout of the Frame
        add(new Label("Enter an Integer: ")); // Adding an anonymous Label to Frame

        /* TextField components: where the user will enter values.
        A column is an approximate average character width
        that is platform-dependent.
         */
        tfInput = new TextField(10);
        add(tfInput);

        /* A listener taking this TextField as the source.
        When the user types something into "tfInput" and presses Enter,
        an action event is generated, which will be handled by the "actionPerformed"
        method of the inner class TFInputListener.
         */
        tfInput.addActionListener(new TFInputListener());

        add(new Label("The Accumulated Sum is: "));

        tfOutput = new TextField(10);
        // The "tfOutput" component is set to ReadOnly.
        tfOutput.setEditable(false);
        add(tfOutput);

        // Set the title, size and visibility of the Frame.
        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        // The AWTAccumulator is invoked to set up the GUI.
        new AWTAccumulator();
    }

    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            // The String input will be transformed into an integer.
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            /* The input "tfInput" and the output "tfOutput" is
            updated to reflect the new sum
             */
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }




}
