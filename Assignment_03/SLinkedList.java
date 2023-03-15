// I referenced GeeksForGeeks's page on implementing a singly-linked list using a queue.
// The url is https://www.geeksforgeeks.org/queue-linked-list-implementation/ 
// I also referenced this Youtube video: https://www.youtube.com/watch?v=A5_XdiK4J8A 

public class SLinkedList {
    private Node head;
    private Node tail;
    private int len;

    public SLinkedList() {
        this.head = null;
        this.tail = null;
        this.len = 0;
    }

    void enqueue(String x) {
        Node temp = new Node(x);
        this.len++;

        if (isEmpty()) {
            this.tail = temp;
            this.head = temp;
            return;
        }

        this.tail.next = temp;
        this.tail = temp;
    }

    public String dequeue() {
        if (isEmpty()) {
            return "";
        }

        Node temp = this.head;
        this.head = this.head.next;

        if (this.head == null) {
            this.tail = null;
        }
        this.len--;
        return temp.name;
    }

    public String first() {
        return this.head.name;
    }

    public int size() {
        return this.len;
    }

    public boolean isEmpty() {
        return this.tail == null;
    }
}
