public class SLinkedListTest {
    public static void main(String[] args) {
        SLinkedList list = new SLinkedList();
        list.enqueue("Cecilia");
        list.enqueue("Jessica");
        list.dequeue();
        list.enqueue("Alyssia");
        list.enqueue("Diego");
        list.enqueue("Emilia");
        list.dequeue();
        list.dequeue();
        System.out.println("Head of List: " +  list.first());
        System.out.println("Size of List: " + list.size());
    }
    
}
