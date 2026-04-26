/*Q1. Write a Java Program for Checking if a given string is null or contains only whitespace usinguser
defined function isNullOrEmpty().*/


package array;

import java.util.Scanner;

public class CheckNullOrEmpty {

    // User-defined function
    public static boolean isNullOrEmpty(String str) {
        // Check if null or only whitespace
        return (str == null || str.trim().isEmpty());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Check using function
        if (isNullOrEmpty(input)) {
            System.out.println("The string is null or contains only whitespace.");
        } else {
            System.out.println("The string is NOT null or empty.");
        }

        sc.close();
    }
}