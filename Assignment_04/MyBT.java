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
    private Node insert_add(Node curr, int i){
        // check if the value is a duplicate
        if (curr==null || size == 0) {
            curr = new Node(i);
            tracksize();
        } else if (i == curr.elem) {
            System.out.println("The value already exists in the Tree");
        }
        /*remember the rule which is that the left child node's value must always be 
        of a lesser value than it's direct parent so here we check*/
        else if(i < curr.elem){
            curr.left = insert_add(curr.left, i);
        }
        else{
            curr.right = insert_add(curr.right, i);
        }
        return curr;
    }

    void insert(int i){
        Node trav = root;
    	trav = insert_add(trav, i);
    }

    // tree traversal method
    private Node traversal(){
        Node trav;
        trav = root;

        // since insertion always starts from the left, traverse the left node
        while(trav != null){
            trav = trav.left;
        }
        return trav;
    }

    // size tracker. adds to size every time we add node
    private void tracksize(){
        this.size++;
    }

    // Will search for given integer and return whether or not "i" is in the tree (not too sure if i need to find index), 
    // plan: create a node that tracks node we are looking at and check if "i" matches that node, if not traverse either right or left
     
    /**
     * @param int that we are looking for
     * @return idx of element if found, if not found return -1
     * Should we return idx or just the level of the node?
     * If it is the idx, wht is the most efficient way to do so? 
     *    Is the idx considered the order of the node from leftmost, all its children, to right?
     *    Or is it left to right?
     *    Or it it how many nodes you have to go through, in the shortest path, to get to the node?
    */

    // Will search for given integer and return whether or not "i" is in the tree (not too sure if i need to find index), 
    // plan: create a node that tracks node we are looking at and check if "i" matches that node, if not traverse either right or left
    // AMANDA CHANGED:

    // ***used 2.6.2 Binary Search Recursive Method Video to help structure this recusrive search private method***
    //helper search method that is a preorder traversal
    private int recsearch(Node current, int target, int index){
        if (current == null){
            return -1;
        }
        else if (target == current.elem){
            return index;
        }
        else if (target < current.elem){ 
            return recsearch(current.left, target, index+1);
        } else {
            //if searching right node, add one to index if there exists a left node. add to index in parameter call
            if (current.left != null)
                index += 1;
            return recsearch(current.right, target, index+1);
        }
    }

    public int search(int i){
        return recsearch(root, i, 0);
    }

    //this returns elem of node that we tried to delete
    public Integer delete (int i){
        Integer index = search(i) != -1 ? i : null; 
        this.root = delete_node(this.root,i);
        return index;
    }
    
    // goal: create a node that contains the parent and current node like in the search method
    // check that there exists a tree
    // check if either side of parent exists then go from there, make sure to reduce size because delete method reduces the size of the tree
    private Node delete_node(Node current, int i){
        if (current == null) {
            System.out.println("Attempt to delete node: There is no Tree or that value does not exist");
            return current; //return node if tree doesn't exist or value doesn't exist
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
                //set current element to the minRight node that branches from the original current.right node. this becomes the node that replaces the deleted node 
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

    // find the node with min value, this is used in delete_node method
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
