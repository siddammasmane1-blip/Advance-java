/*Basic hello program of Swing displaying the message Hello! VI C , Welcome to Swing Programming in Blue color plain font with font size of 32 using Jframe and Jlabel
*/


package swing;
import javax.swing.*;
import java.awt.*;

public class HelloSwing {
    public static void main(String[] args) {

        // Create JFrame
        JFrame frame = new JFrame("Swing Hello Program");

        // Create JLabel with message
        JLabel label = new JLabel("Hello! VI C , Welcome to Swing Programming");

        // Set font: Plain, size 32
        label.setFont(new Font("Arial", Font.PLAIN, 32));

        // Set text color to Blue
        label.setForeground(Color.BLUE);

        // Center align text
        label.setHorizontalAlignment(JLabel.CENTER);

        // Add label to frame
        frame.add(label);

        // Set frame size
        frame.setSize(800, 200);

        // Close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make frame visible
        frame.setVisible(true);
    }
}