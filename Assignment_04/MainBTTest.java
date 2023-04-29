public class MainBTTest {
	public static void main(String[] args) {
		MyBT daT = new MyBT(2);
        System.out.println("We instantiated the list with 1 element.");
        daT.insert(4);
        daT.insert(3);

        System.out.println("We inserted 2 elements.");
        System.out.println("The tree has " + daT.size() + " elements.");
        System.out.println("Here are the elements in the Binary Tree in-order.");
        daT.printBT();
        System.out.println("Here are the elements in the Binary Tree pre-order.");
        daT.printBT("Pre");
        System.out.println("Here are the elements in the Binary Tree post-order.");
        daT.printBT("Post");

        //searching for elements
        int searchElem = daT.search(3);
        System.out.println("Searching for element 3, index is: " + searchElem);
        System.out.println("Search for element 5 (does not exist in list), index is: " + daT.search(5));
        
        //deleting elements
        System.out.println("Deleting element 4, return element: " + daT.delete(4));
        System.out.println("Here are the elements in the Binary Tree in-order.");
        daT.printBT();
        System.out.println("Deleting an element that doesn't exist in the tree (element 7), return element: " + daT.delete(7));
        

        //creating another binary tree
        MyBT daT2 = new MyBT(2, 5, 1);
        System.out.println("\nWe instantiated another list with 3 elements.");
        daT2.insert(7);
        daT2.insert(6);
        daT2.insert(8);

        System.out.println("We inserted 3 elements.");
        System.out.println("The tree has " + daT2.size() + " elements.");
        System.out.println("Here are the elements in the Binary Tree in-order.");
        daT2.printBT();
        System.out.println("Here are the elements in the Binary Tree pre-order.");
        daT2.printBT("Pre");
        System.out.println("Here are the elements in the Binary Tree post-order.");
        daT2.printBT("Post");

        //searching for elements
        searchElem = daT2.search(1);
        System.out.println("Searching for element 1, index is: " + searchElem);
        searchElem = daT2.search(6);
        System.out.println("Searching for element 6, index is: " + searchElem);
        searchElem = daT2.search(5);
        System.out.println("Searching for element 5, index is: " + searchElem);

        System.out.println("Search for element 3 (does not exist in list), index is: " + daT2.search(3));

        //deleting elements
        System.out.println("Deleting element 6, return element: " + daT2.delete(6));
        System.out.println("Here are the elements in the Binary Tree in-order.");
        daT2.printBT();
        System.out.println("Deleting an element that doesn't exist in the tree (element 10), return element: " + daT2.delete(10));
    }
}
