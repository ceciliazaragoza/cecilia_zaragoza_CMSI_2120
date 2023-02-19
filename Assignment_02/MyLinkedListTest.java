public class MyLinkedListTest {
	public static void main(String[] args) {
		
		//create nodes
		//edit nodes so that they have different information
		Node nada = new Node(); 
		Node wkday = new Node("Weekday");
		Node mday = new Node("Monday");
		Node tuday = new Node("Tuesday");
		Node wday = new Node("Wednesday");
		Node thday = new Node("Thursday");
		Node fday = new Node("Friday");
		Node saday = new Node("Saturday");
		Node suday = new Node("Sunday");
		
		// create Linked list and add nodes
		MyLinkedList testList = new MyLinkedList();
		testList.add(nada);
		testList.add(mday);
		testList.add(wday);
		testList.add(thday);
		testList.add(saday);
		
		// print each element in the Linkedlist
		testList.printList();
		//print current size
		System.out.println("The LinkedList is of size " + testList.size());
		System.out.println("\n");
		
		// insert before
		testList.insertBefore(1, wkday);
		testList.insertBefore(3, tuday);
		
		// print each element in the Linkedlist
		testList.printList();
		System.out.println("The LinkedList is of size " + testList.size());
		System.out.println("\n");
		
		//insert after
		testList.insertAfter(5, fday);
		testList.insertAfter(7, suday);
		
		// print each element in the Linkedlist
		testList.printList();
		System.out.println("The LinkedList is of size " + testList.size());
		System.out.println("\n");
				
		//indexof fday node
		System.out.println(testList.indexOf("friday"));
		System.out.println("\n");
		
		//remove
		testList.removeNodeAt(1);

		// print each element in the Linkedlist
		testList.printList();
		System.out.println("The LinkedList is of size " + testList.size());
		System.out.println("\n");
	}

}

