/*Write a Java Program for Capitalizing the first letter of each word. using user defined function
capitalizeWords()
*/
/*Write a Java Program for Capitalizing the first letter of each word. using user defined function
capitalizeWords()*/


package array;

import java.util.Scanner;

public class CapitalizeWordsExample {

    // User-defined function
    public static String capitalizeWords(String str) {

        String[] words = str.split("\\s+"); // split by whitespace
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                // Capitalize first letter + rest in lowercase
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1).toLowerCase())
                      .append(" ");
            }
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String output = capitalizeWords(input);

        System.out.println("Capitalized string: " + output);

        sc.close();
    }
}