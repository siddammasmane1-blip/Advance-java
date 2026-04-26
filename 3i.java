/*Write a Java Program for Creating a random string of a specified length using user defined
function generateRandomString()*/


package array;

import java.util.Scanner;
import java.util.Random;

public class RandomStringExample {

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(characters.length());
            result.append(characters.charAt(index));
        }
        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter desired length: ");
        String input = sc.nextLine();  // read as string

        try {
            int length = Integer.parseInt(input);  // convert to int

            String randomString = generateRandomString(length);
            System.out.println("Generated Random String: " + randomString);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a number.");
        }

        sc.close();
    }
}