/*4cDevelop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour Glassis pressed” depending upon the Jbutton with image either Digital Clock or Hour Glass is pressed by implementing the event handling mechanism with addActionListener( ).
*/


package swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageButtonExample implements ActionListener {

    JFrame frame;
    JLabel label;
    JButton btnClock, btnHourGlass;

    public ImageButtonExample() {

        // Create frame
        frame = new JFrame("Image Button Example");

        // Create label
        label = new JLabel("Press a button");
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setHorizontalAlignment(JLabel.CENTER);

        // Load images (make sure images are in project folder)
        ImageIcon clockIcon = new ImageIcon("clock.png");
        ImageIcon hourGlassIcon = new ImageIcon("hourglass.png");

        // Create buttons with images
        btnClock = new JButton("Digital Clock", clockIcon);
        btnHourGlass = new JButton("Hour Glass", hourGlassIcon);

        // Add ActionListener
        btnClock.addActionListener(this);
        btnHourGlass.addActionListener(this);

        // Layout
        frame.setLayout(new FlowLayout());

        // Add components
        frame.add(label);
        frame.add(btnClock);
        frame.add(btnHourGlass);

        // Frame settings
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Event handling
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnClock) {
            label.setText("Digital Clock is pressed");
        } else if (e.getSource() == btnHourGlass) {
            label.setText("Hour Glass is pressed");
        }
    }

    public static void main(String[] args) {
        new ImageButtonExample();
    }
}