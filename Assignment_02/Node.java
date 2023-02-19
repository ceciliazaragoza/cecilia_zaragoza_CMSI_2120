class Node {
    public String name;
    public Node next;
    
    Node( ) { 
    	this.name = "*";
    	this.next = null;
        
    }
    Node(String  s) { //having 2 constructors is called overloading
    	this.name = s;
    	this.next = null;
    }
}
