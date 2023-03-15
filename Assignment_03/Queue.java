/*
 * Read sections 6.2 and 6.3 (from pages 238 to 251) of Data Structures and Algorithms in Java, 6th Edition.
 * Use the Queue interface below to write a Singly Linked List:
 * 
 * create node class
 * 
 * create queue interface
 * 
 * create single linked list using queue interface
 */
public interface Queue {

    public void enqueue(String x);
    public String dequeue();
    public String first();
    public int size();
    public boolean isEmpty();
}