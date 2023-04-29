public class SLinkedListTest {
    public static void main(String[] args) {
        SLinkedList list = new SLinkedList();
        System.out.println("Calling dequeue method on empty list, should return String that says list is empty.");
        String deletedData = list.dequeue();
        System.out.println("Deleted node: " + deletedData + "\n");
        list.printList();

        System.out.println("Adding 2 elements.");
        list.enqueue("One");
        list.enqueue("Two");
        list.printList();

        System.out.println("Calling dequeue method once, returning and removing first element.");
        deletedData = list.dequeue();
        System.out.println("Deleted node: " + deletedData + "\n");
        list.printList();
        
        System.out.println("Adding 3 elements.");
        list.enqueue("Three");
        list.enqueue("Four");
        list.enqueue("Five");
        list.printList();

        System.out.println("Calling dequeue method twice, returning and removing each element.");
        deletedData = list.dequeue();
        System.out.println("Deleted node: " + deletedData + "\n");
        deletedData = list.dequeue();
        System.out.println("Deleted node: " + deletedData + "\n");
        list.printList();

        System.out.println();
        System.out.println("Head of List: " +  list.first());
        System.out.println("Size of List: " + list.size());
        System.out.println("Is this list empty? " + list.isEmpty());
    }
}
