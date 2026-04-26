package array;
import java.util.ArrayList;
import java.util.List;

public class ColorArrayListExample {
    public static void main(String[] args) {

        // Create ArrayList to store colors
        ArrayList<String> colors = new ArrayList<>();

        // Add elements to ArrayList
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Black");

        // Display original list
        System.out.println("Original ArrayList: " + colors);

        // Extract 1st and 2nd elements using subList()
        List<String> subColors = colors.subList(0, 2);

        // Display extracted elements
        System.out.println("Extracted elements (1st and 2nd): " + subColors);
    }
}