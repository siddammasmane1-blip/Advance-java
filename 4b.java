/*Develop a Swing program in Java to display a message “Srilanka is pressed” or “India is pressed” depending upon the Jbutton either Srilanka or India is pressed by implementing the event handling mechanism with addActionListener( ).*/


package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountryButtonExample implements ActionListener {

    JFrame frame;
    JLabel label;
    JButton btnIndia, btnSrilanka;

    public CountryButtonExample() {

        // Create frame
        frame = new JFrame("Country Button Example");

        // Create label
        label = new JLabel("Press a button");
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setHorizontalAlignment(JLabel.CENTER);

        // Create buttons
        btnIndia = new JButton("India");
        btnSrilanka = new JButton("Srilanka");

        // Add ActionListener
        btnIndia.addActionListener(this);
        btnSrilanka.addActionListener(this);

        // Set layout
        frame.setLayout(new FlowLayout());

        // Add components
        frame.add(label);
        frame.add(btnIndia);
        frame.add(btnSrilanka);

        // Frame settings
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Event handling
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnIndia) {
            label.setText("India is pressed");
        } else if (e.getSource() == btnSrilanka) {
            label.setText("Srilanka is pressed");
        }
    }

    public static void main(String[] args) {
        new CountryButtonExample();
    }
}