public class MyCirLinkedList {
  private Node head;
	private Node last;
	public int size;
	/**
   * Circle Linked List Constructor
   * A Circle Linked List includes a head reference
   * to a Node object. Each Node object
   * has a reference to the next Node object.
   * The final Node in the list has a reference
   * to the head Node.
   */
  MyCirLinkedList(){
    this.head = null;
    this.last = null;
    this.size = 0;
  }

	public boolean isEmpty() {
		return head==null;
	}

	public int size() {
		return size + 1;
	}
	
  /**
   * Add a node to the end of the list
   * @param n Node to add to the list
   */
  public void add(Node n){
    if (head==null) {
      // first element
      n.next = n;
      head = n;
    } else {
      n.next = head;
      last.next = n;
      this.size++;
    }
    last = n;
  }
  /**
   * Print each element in the list
   */
  public void printList(){
    Node trav;
    trav = head;
    int count = 0;
    while (count < size + 1) { 
      System.out.println(trav.name);
      trav = trav.next;
      count++;
    }
  }
  /**
   * Insert a node before the node at the given index
  */
  public void insertBefore(int index, Node n){
    if (index < 0 || index > size) {	
      //since insertion is before, can't insert node in a -1 index
      System.out.println("Insertion index out of bounds");
    } else if (index == 1) {
      n.next = head.next;
      head.next = n;
      this.size++;
    } else {
      Node trav;
      trav = head;
      int count = 0;
      while (count != index - 1) {
        trav = trav.next;
        count++;
      }
      n.next = trav.next;
      trav.next = n;
      this.size++;
    }   
  }
  /**
   * Insert a node after the node at the given index
   */
  public void insertAfter(int index, Node n){
    // adds Node n after index value
    if (index < 0 || index > size + 1)
    {	//since insertion is after, can't insert node in an index above the current size
      System.out.println("Insertion index out of bound");
    }
    else if (index == 0)
    {
      n.next = head.next;
      head.next = n;
      this.size++;
    }
    else {
      int count = 0;
      Node trav;
      trav = head;
      while (count != index) {
        trav = trav.next;
        count++;
      }
      n.next = trav.next;
      trav.next= n;
      this.size++;
    }
  }
  /**
   * Return the index of the first node that contains the given data.
   * Returns -1 if the data is not found.
   * @return
   */
  public int indexOf(String str){
    Node trav;
    trav = head;
    for (int idx = 0; idx < size; idx++) {
      if (trav.name.equalsIgnoreCase(str)) {
        return idx;
      }
      trav = trav.next;
    }
    return -1;
  }
  /**
   * Remove the node at the given index
   */
  public void removeNodeAt(int index){
    // removes Node at index value
		if((index > size) || (index < 0))
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
			
			this.size--; 
		}   	

  }
        
}