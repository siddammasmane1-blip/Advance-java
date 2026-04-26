/*rite a Java program to iterate through all elements in a linked list starting at the
specified position ( 2
nd) using iterator ( hint : Iterator iteratorobj = listobj.listIterat*/


package array;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListIteratorExample {
    public static void main(String[] args) {

        // Create LinkedList
        LinkedList<String> list = new LinkedList<>();

        // Add elements
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.add("Yellow");
        list.add("Black");

        // Display original list
        System.out.println("Original LinkedList: " + list);

        // Get ListIterator starting from index 1 (2nd position)
        ListIterator<String> iteratorobj = list.listIterator(1);

        // Iterate from 2nd position
        System.out.println("Elements from 2nd position:");
        while (iteratorobj.hasNext()) {
            System.out.println(iteratorobj.next());
        }
    }
}