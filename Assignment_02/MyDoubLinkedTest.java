public class MyDoubLinkedTest {
    public static void main(String[] args) {
		
		//create nodes
		DoubleNode nada = new DoubleNode(); 
		DoubleNode color = new DoubleNode("Color");
		DoubleNode red = new DoubleNode("Red");
		DoubleNode orange = new DoubleNode("Orange");
		DoubleNode yellow = new DoubleNode("Yellow");
		DoubleNode green = new DoubleNode("Green");
		DoubleNode blue = new DoubleNode("Blue");
		DoubleNode purple = new DoubleNode("Purple");
		DoubleNode violet = new DoubleNode("Violet");
		
		// create Linked list and add nodes
		MyDoubLinkedList testList = new MyDoubLinkedList();
		testList.add(nada);
		testList.add(red);
		testList.add(yellow);
		testList.add(green);
		testList.add(purple);
		
		// print each element in the Linkedlist
		testList.printList();
		//print current size
		System.out.println("The DoubLinkedList is of size " + testList.size());
		System.out.println("\n");
		
		// insert before
		testList.insertBefore(1, color);
		testList.insertBefore(3, orange);
		
		// print each element in the Linkedlist
		testList.printList();
		System.out.println("The DoubLinkedList is of size " + testList.size());
		System.out.println("\n");
		
		//insert after
		testList.insertAfter(5, blue);
		testList.insertAfter(7, violet);
		
		// print each element in the Linkedlist
		testList.printList();
		System.out.println("The DoubLinkedList is of size " + testList.size());
		System.out.println("\n");
				
		//indexof blue node
		System.out.println(testList.indexOf("friday"));
        System.out.println("\n");
		
		//remove
		testList.removeNodeAt(1);

		// print each element in the Linkedlist
		testList.printList();
		System.out.println("The DoubLinkedList is of size " + testList.size());
		System.out.println("\n");
	}
}
