// I referenced GeeksForGeeks's page on implementing a singly-linked list using a queue.
// The url is https://www.geeksforgeeks.org/queue-linked-list-implementation/ 
// I also referenced this Youtube video: https://www.youtube.com/watch?v=A5_XdiK4J8A 

public class SLinkedList implements Queue { //I made sure to add this line that implements Queue
    private Node head;
    private Node tail;
    private int size;

    public SLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //add node at end of list
    public void enqueue(String x) {
        Node newNode = new Node(x);

        if (this.head == null) {
            this.tail = newNode;
            this.head = newNode;
            this.size = 1;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
            this.size++;
        }
    }

    //remove first node from list
    public String dequeue() {
        if (this.head == null) {
            System.out.println("Sorry! This list is empty."); //is it okay to have this print to terminal or should I have method throw an error?
            return null; //changed to return null, not an empty string
        } else {
            Node oldHead = this.head;
            this.head = this.head.next;
            this.size--;
            return oldHead.data;
        }
    }

    public String first() {
        if (this.head == null) { //changed to return null if list is empty
            System.out.println("Sorry! This list is empty.");
            return null;
        }
        return this.head.data;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void printList() {
        Node current = head;
        System.out.println("Updated List:");
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
