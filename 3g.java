/*Write a Java Program for Shortening a string to a specified length and adds an ellipsis usinguser
defined function truncate()*/


package array;

import java.util.Scanner;

public class TruncateStringExample {

    // User-defined function
    public static String truncate(String str, int maxLength) {

        // If string is null or already within limit
        if (str == null || str.length() <= maxLength) {
            return str;
        }

        // Ensure space for "..."
        if (maxLength > 3) {
            return str.substring(0, maxLength - 3) + "...";
        } else {
            // If maxLength is too small, just cut the string
            return str.substring(0, maxLength);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.print("Enter maximum length: ");
        int length = sc.nextInt();

        String result = truncate(input, length);

        System.out.println("Truncated string: " + result);

        sc.close();
    }
}
