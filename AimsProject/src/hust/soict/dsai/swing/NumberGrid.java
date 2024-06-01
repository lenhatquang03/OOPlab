package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame{
    /* First-level component = JFrame: used for the application's
    main window.
     */
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);

        /* Secondary-level containers: group and layout relevant
        components.
         */
        JPanel panelButtons = new JPanel(
                new GridLayout(3, 4));
        addButtons(panelButtons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(200, 200);
        setVisible(true);
    }

    void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton("" + i);
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    private class ButtonListener implements ActionListener {
        @Override
        /* Here, ActionEvent.getActionCommand() retrieves a "String"
        associated with the action event. In this case, if it is not
        stated, the default value would be the names of the buttons.
         */

        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                tfDisplay.setText(tfDisplay.getText() + button);
            }
            else if (button.equals("DEL")) {
                tfDisplay.setText(tfDisplay.getText().substring(
                        0, tfDisplay.getText().length() - 1));
            }
            else if (button.equals("C")) {
                tfDisplay.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}

/* The process and structure are as follows:
--- STRUCTURE ---
+ First-level component: JFrame is used to create the application's
window,
+ Second-level component: JPanel is used to STORE ALL BUTTONS.
+ Container is used to GROUP both the panel button and the text displayed.
--- PROCESS ---
+ The JButton.addActionListener(btnListener) is activated whenever
a button is pressed.
+ An action event is created, and it will be handled by the "btnListener".
+ Depends on what button is pushed that the "tfDisplay" is updated.
 */
