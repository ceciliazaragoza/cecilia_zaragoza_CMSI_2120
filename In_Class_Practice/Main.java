import java.util.*;

public class Main {
    public static void main(String[] args) {
        int w = 10;
    ArrayList<Integer> test_a = new ArrayList<Integer>();
    MyLinearSearch v = new MyLinearSearch();
    test_a.add(2);
    test_a.add(7);
    test_a.add(9);
    test_a.add(5);
    test_a.add(10);
    test_a.add(15);
    test_a.add(20);
    int val = v.arrEquality(test_a, w);
    System.out.println(val);
    }
}
