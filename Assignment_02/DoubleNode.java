public class DoubleNode{
    public String name;
    public DoubleNode next;
    public DoubleNode prev;

    public DoubleNode() {
        this.name = "*";
        this.next = null;
        this.prev = null;
    }

    public DoubleNode(String name){
        // TODO: Implement the constructor
        this.name = name;
        this.next = null;
        this.prev = null;
    }
}