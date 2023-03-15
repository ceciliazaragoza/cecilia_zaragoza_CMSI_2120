/* 
 * Step 1: declare class
 * Step 2: initiallize array
 * Step 3: declare your constructor
 * Step 4: declare an equality method
 *      this is the for loop 
 */

import java.util.*;

class MyLinearSearch {
    ArrayList<Integer> arr = new ArrayList<Integer>();

    MyLinearSearch() {
       
    }

    public int arrEquality(ArrayList<Integer> x, int a) {
        int idx = -1;
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i) == a) {
                idx = i;
                break; //this is a stylistic choice. having multiple return statements isn't pleasing to some people
            }
        }
        return idx;
    }
}
