class MyLinkedList {
	private Node head;
	private int len;
	
	MyLinkedList() {
	     head = null;
		 //don't put null in for the tail
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return len + 1;
	}
	
	public void add(Node n) {
		if (head==null) {
			// first element
			head = n;
			this.len = 0;
		} else {
			Node trav;
			trav = head;
			while (trav.next != null) {
				trav = trav.next;
			}
			trav.next = n;
			this.len++;
		}
	}
	
	public void printList() {
		Node trav;
		trav = head;
		while (trav != null) {
			System.out.println(trav.name);
			trav = trav.next;
		}
	}
	
	public void insertBefore (int index,  Node n)  {
		// adds Node n before index value
		
		if (index < 0 || index > len)
		{	//since insertion is before, can't insert node in a -1 index
			System.out.println("Insertion index out of bound");
		}
		else if (index == 0) 
		{
			n.next = head;
			head = n;
			this.len++;
		}
		else 
		{
			int count = 0;
			Node trav;
			trav = head;
			while (count != index - 1) {
				trav = trav.next;
				count++;
			}
			n.next = trav.next;
			trav.next= n;
			this.len++;
		}
	}
	
	public void insertAfter (int index,  Node n)  { 
		// adds Node n after index value
		if (index < 0 || index > len + 1)
		{	//since insertion is after, can't insert node in an index above the current size
			System.out.println("Insertion index out of bound");
		}
		else if (index == 0)
		{
			n.next = head.next;
			head.next = n;
			this.len++;
		}
		else
		{
			int count = 0;
			Node trav;
			trav = head;
			while (count != index) {
				trav = trav.next;
				count++;
			}
			n.next = trav.next;
			trav.next= n;
			this.len++;
		}
	}
	
	public int indexOf (String  str) {
		/*returns index of where String str is at.  
		* Returns -1 if String str is not in LinkedList
		*/
		Node trav;
		trav = head;
		for (int idx = 0; idx < len; idx++) {
			if (trav.name.equalsIgnoreCase(str)) {
			return idx;
			}
			trav = trav.next;
		}
		return -1;
		
	}
	
	public void removeNodeAt(int index) {
		// removes Node at index value
		if (index < 0 || index > len)
		{
			System.out.println("Insertion index out of bound");  
		}
		else
		{
			Node trav;
			trav = head;
			int counter = 0;
			while (counter < index-1)
			{
				trav = trav.next;
				counter++;
			}
			Node r;
			r = trav.next.next;
			trav.next = r;
			
			this.len--; 
		}   	
	}
}
