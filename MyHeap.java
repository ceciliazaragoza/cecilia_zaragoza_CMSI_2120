import java.util.ArrayList;
import java.util.NoSuchElementException;


public class MyHeap<T extends Comparable<T>> {
	
/**
	 * @author Sesh Venugopal. New Jersey. 2013
	 */

		
	private int[] items;
	
	public MyHeap(int len) {
		items = new int[len];
	}

	
	//shifting nodes in heap
	private void siftUp() {
		int k = items.length - 1;
		while (k > 0) {
			int p = (k-1)/2;
			int item = items[k];
			int parent = items[p];
			if (item > parent) {
				// swap
				items[k] = parent;
				items[p] = item;
				
				// move up one level
				k = p;
			} else {
				break;
			}
		}
	}
	
	public void insert(int item) {
		boolean set = false;
		for (int idx = 0; idx < items.length; idx++) {
			if (items[idx] == 0) {
				items[idx] = item;
				set = true;
			}
		}
		if (!set) {
			//create new array and copy over information from old array to new array.
			//then make that length 1 greater than the old array
			items[items.length] = item;
		}
		siftUp();
	}
	
	private void siftDown() {
		int k = 0;
		int l = 2*k+1;
		while (l < items.length) {
			int max=l, r=l+1;
			if (r < items.length) { // there is a right child
				if (items[r] > items[l]) {
					max++;
				}
			}
			if (items[k]< items[max]) {
					// switch
					int temp = items[k];
					items[k] = items[max];
					items[max] = items[temp];
					k = max;
					l = 2*k+1;
			} else {
				break;
			}
		}
	}
	
	public T delete() 
	throws NoSuchElementException {
		if (items.length == 0) {
			throw new NoSuchElementException();
		}
		if (items.size() == 1) {
			return items.remove(0);
		}
		T hold = items.get(0);
		items.set(0, items.remove(items.size()-1));
		siftDown();
		return hold;
	}

	public int size() {
		return items.size();
	}
	
	public boolean isEmpty() {
		return items.isEmpty();
		
	}
	
	public String toString() {
		
		return items.toString();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHeap heap = new MyHeap();


	}

}
