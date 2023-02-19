/*
 * Wk 3-1 Lab: Arraylist
 * Go through the ArrayList Java documentation.
 * Play around with ArrayList, try to create a class that implements ArrayList. It doesn’t have to be perfect
 * Upload your java file.
 */
import java.util.ArrayList;

public class Wk_3_1_Lab {
    public static void printAll(ArrayList<String> arrList) {
        for (int idx = 0; idx < arrList.size(); idx++) {
            System.out.println(arrList.get(idx));
        }
        System.out.println("Size: " + arrList.size() + "\n");
    }
    public static void main(String[] args) {
        ArrayList<String> dogs = new ArrayList<String>();
        //add items to the list. each item is added to the end of the list
        dogs.add("Poodle");
        dogs.add("Yorkie");
        dogs.add("Labrador");
        dogs.add("Golden Retriever");
        printAll(dogs);

        // add dogs at specific indicies
        dogs.add(4, "Chihuahua");
        dogs.add(3, "Pug");
        printAll(dogs);
        
        //get the string at index 2
        System.out.println("The string at index 2: " + dogs.get(2));
        System.out.println("\n");

        //set the string at index 1 to a new string 
        dogs.set(1, "Husky");
        printAll(dogs);

        //remove the string at index 4
        dogs.remove(4);
        printAll(dogs);

        //get the index of the first occurrence string "labrador"
        System.out.println("Index of first occurrence of string \"Labrador\": " + dogs.indexOf("Labrador"));
        printAll(dogs);
        
        //sort the strings into alphabetical order
        dogs.sort(null);
        printAll(dogs);
    }
}
