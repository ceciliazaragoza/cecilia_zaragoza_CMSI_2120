public class MyBT {

    private Node root;
    private int size = 0;

    MyBT(){
        root = null;
    }

    MyBT(int i){
        root = new Node(i);
        tracksize();
    }

    // assuming you have the first 3 elements of the binary tree
    MyBT(int i, int y, int w){
		root = new Node(i);
		tracksize();
		 if(y < i &&  w > y){
		     root.left = new Node(y);
		     tracksize();
		     root.right = new Node(w);
		     tracksize();
		     root.left.left=root.left.right=null;  
		     root.right.left=root.right.right=null; 
		 }
		 else if (y > i &&  w < i){
			 root.left = new Node(w);
			 tracksize();
		     root.right = new Node(y);
		     tracksize();
		     root.left.left=root.left.right=null;  
		     root.right.left=root.right.right=null;    
		 }
    }

    // insert using recursion
    private Node insert_add(Node current, int i){
        // check if the value is a duplicate
        if (current==null) {
            current = new Node(i);
            tracksize();
        } else if (i == current.elem) {
            System.out.println("The value already exists in the Tree");
        }
        /*remember the rule which is that the left child node's value must always be 
        of a lesser value than it's direct parent so here we check*/
        else if(i < current.elem){
            current.left = insert_add(current.left, i);
        }
        else{
            current.right = insert_add(current.right, i);
        }
        return current;
    }

    void insert(int i){
    	root = insert_add(root, i);
    }

    // size tracker. adds to size every time we add node
    private void tracksize(){
        this.size++;
    }
    // Will search for given integer and return whether or not "i" is in the tree (not too sure if i need to find index), 
    // plan: create a node that tracks node we are looking at and check if "i" matches that node, if not traverse either right or left
    public boolean search(int i){
        //start out at root
        Node current = root;
        //iterate throught the entire tree until you are at a Node with value null, which means the value is not in the tree
        while (current != null) {
            if (i == current.elem) {
                System.out.println("The value is in tree!");
                return true;
            //if target int is less than current.elem, then go to left which has a smaller value
            } else if (i < current.elem) {
                current = current.left;
            //if target int is greater than current.elem, then go to right which has greater value
            } else {
                current = current.right;
            }
        }
        System.out.println("The value is not in Tree.");
        return false;
    }
    
   
    public void delete(int i){
        root = delete_node(root,i);
    }
    
    // goal: create a node that contains the parent and current node like in the search method
    // check that there exists a tree
    // check if either side of parent exists then go from there, make sure to reduce size because delete method reduces the size of the tree
    private Node delete_node(Node current, int i){
        if (current == null) {
            System.out.println("There is no Tree or that value does not exist");
            return null;
        }
        //check to see if we find the node that we're looking for
        if (i == current.elem) {
            if (current.left == null && current.right == null) {
                size--;
                return null;
            } else if (current.left == null) {
                size--;
                //if there is a right child node, then return that value, this gets saved 
                return current.right;
            } else if (current.right == null){
                size--;
                return current.left;
            } else {
                //if there are 2 children
                Node minRight = find_min(current.right);
                //set current element to the minRight node that branches from the original current.right node 
                current.elem = minRight.elem;
                //delete the old minRight node from where it used to be
                current.right = delete_node(current.right, minRight.elem);
            }
        //use recursion to find correct element
        } else if (i < current.elem){
            //if the elment we are searching for is less than the current, we go to the left of the tree to find the element 
            current.left = delete_node(current.left, i);
        } else {
            //if the elment we are searching for is greater than the current, we go to the right of the tree to find the element 
            current.right = delete_node(current.right, i);
        }
        return current;
    }

    // find the node with min value
    private Node find_min(Node current) {
        while (current.left != null){
            current = current.left;
        }
        return current;
    }
        
    void printBT(){
        Node trav;
        trav = root;
        inorderprint(trav);
        
    }
    
    void printBT(String s){
        Node trav;
        trav = root;
        if(s.equalsIgnoreCase("pre")) {
        	preorderprint(trav);
        }
        else if (s.equalsIgnoreCase("post")) {
            postorderprint(trav);
         }        
    }
    
    void inorderprint(Node n) {
    	if(n != null){ 
    		inorderprint(n.left);
            System.out.println(n.elem);
            inorderprint(n.right);
        }
    }
    
    void preorderprint(Node n) {
    	if(n != null){ 
    		System.out.println(n.elem);
    		preorderprint(n.left);
            preorderprint(n.right);
        }
    }
    
    void postorderprint(Node n) {
    	if(n != null){ 
    		postorderprint(n.left);
            postorderprint(n.right);
            System.out.println(n.elem);
    		
        }
    }
    
    int size(){
        return this.size;
    }
    
}
