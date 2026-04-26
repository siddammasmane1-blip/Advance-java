/*Write a Java Program for Counting the number of words in a string using user defined function
countWords()*/


package array;

import java.util.Scanner;

public class WordCountExample {

    // User-defined function
    public static int countWords(String str) {

        // Check null or empty
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }

        // Split string by one or more spaces
        String[] words = str.trim().split("\\s+");

        return words.length;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int count = countWords(input);

        System.out.println("Number of words: " + count);

        sc.close();
    }
}