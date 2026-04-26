/*Write a Java Program for Verifying if a string contains only numeric characters using user defined
function isNumeric()*/


package array;

import java.util.Scanner;

public class CheckNumeric {

    // User-defined function
    public static boolean isNumeric(String str) {

        // Check null or empty
        if (str == null || str.length() == 0) {
            return false;
        }

        // Check each character
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isNumeric(input)) {
            System.out.println("The string contains only numeric characters.");
        } else {
            System.out.println("The string does NOT contain only numeric characters.");
        }

        sc.close();
    }
}

