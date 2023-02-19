public class MyCirLinkedTest {
    public static void main(String[] args) {
		
		//create nodes
		Node nada = new Node(); 
		Node color = new Node("Color");
		Node red = new Node("Red");
		Node orange = new Node("Orange");
		Node yellow = new Node("Yellow");
		Node green = new Node("Green");
		Node blue = new Node("Blue");
		Node purple = new Node("Purple");
		Node violet = new Node("Violet");
		
		// create Linked list and add nodes
		MyCirLinkedList testList = new MyCirLinkedList();
		testList.add(nada);
		testList.add(red);
		testList.add(yellow);
		testList.add(green);
		testList.add(purple);
		
		// print each element in the Linkedlist
		testList.printList();
		//print current size
		System.out.println("The CirLinkedList is of size " + testList.size());
		System.out.println("\n");
		
		// insert before
		testList.insertBefore(1, color);
		testList.insertBefore(3, orange);
		
		// print each element in the Linkedlist
		testList.printList();
		System.out.println("The CirLinkedList is of size " + testList.size());
		System.out.println("\n");
		
		//insert after
		testList.insertAfter(5, blue);
		testList.insertAfter(7, violet);
		
		// print each element in the Linkedlist
		testList.printList();
		System.out.println("The CirLinkedList is of size " + testList.size());
		System.out.println("\n");
				
		//indexof blue node
		System.out.println(testList.indexOf("friday"));
        System.out.println("\n");
		
		//remove
		testList.removeNodeAt(1);

		// print each element in the Linkedlist
		testList.printList();
		System.out.println("The CirLinkedList is of size " + testList.size());
		System.out.println("\n");
	}
}
