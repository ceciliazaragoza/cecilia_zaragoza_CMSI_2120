public class MyDoubLinkedList {
    private DoubleNode head;
    private int size;

    /**
     * Doubly Linked List Constructor
     * A Doubly Linked List includes a head reference
     * to a DoubleNode object. Each DoubleNode object
     * has a reference to the next DoubleNode object
     * and the previous DoubleNode object.
     */
    MyDoubLinkedList()  {
        head = null;
        this.size = 0;
    }

    public int size() {
        return size + 1;
    }
    /**
     * Add a node to the end of the list
     * @param n DoubleNode to add to the list
     */
    public void add(DoubleNode n){
        if (head == null) {
            // first element
            n.prev = null;
            head = n;

        }
        else {
            DoubleNode trav;
            trav = head;
            while (trav.next != null) {
                trav = trav.next;
            }
            // insert n after the last node that has a null next
            trav.next = n;
            // make trav the prev of the last node n
            n.prev = trav;
            this.size++;
        }
    }
    /**
     * Print each element in the list
     */
    public void printList(){
        DoubleNode trav;
        trav = head;
        while (trav != null) {
            System.out.println(trav.name);
            trav = trav.next;
        }
    }
    /**
     * Insert a node before the node at the given index
     */
    public void insertBefore(int index, DoubleNode n){
        if (index < 0 || index > size) {	
            //since insertion is before, can't insert node in a -1 index
            // TODO: //change to exception!
			System.out.println("Insertion index out of bounds");
		} else if (index == 0) {
            //put n before head
            n.next = head;
            n.prev = null;
            //now n is the new head since n is at the beginning of list
            head = n;
            this.size++;
        } else {
            int count = 0;
            DoubleNode trav;
            trav = head;
            // keep looping until you are at the place before the given index
            while (count != index-1) {
                trav = trav.next;
                count++;
            }
            //once you are at the place before the given index, the inserted node, n, will be inserted at place before index 
            n.next = trav.next;
            n.prev = trav;
            trav.next= n;
            this.size++;
		}   
    }
    /**
     * Insert a node after the node at the given index
     */
    public void insertAfter(int index, DoubleNode n) {
        if (index < 0 || index > size + 1) {	
            //since insertion is before, can't insert node in a -1 index
			System.out.println("Insertion index out of bounds");
        } else if (index == 0) {
            n.next = head.next;
            n.prev = head;
            head.next = n;
        } else {
            int count = 0;
            DoubleNode trav;
            trav = head;
            // keep looping until you are at the place before the given index
            while (count != index) {
                trav = trav.next;
                count++;
            }
            //once you are at the place before the given index, the inserted node, n, will be inserted at place before index 
            n.next = trav.next;
            n.prev = trav;
            trav.next= n;
            if (n.next != null) {
                n.next.prev = n;
            }
            this.size++;
		}   
    }
    /**
     * Return the index of the first node that contains the given data.
     * Returns -1 if the data is not found.
     * @return
     */
    public int indexOf(String str){
        DoubleNode trav;
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
        if (index < 0 || index > size) {
            System.out.println("Sorry! This index is out of bounds"); 
        } else {
            int count = 0;
            DoubleNode trav;
            trav = head;
            // keep looping until you are at the place before the given index
            while (count < index - 1) {
                trav = trav.next;
                count++;
            }
            DoubleNode temp;
            temp = trav.next.next;
            trav.next = temp;
            this.size--;
        }
    }
}
