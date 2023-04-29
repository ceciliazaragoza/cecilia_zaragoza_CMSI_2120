import java.util.*;
public class StudentsHashMap {
    public static void main(String args[]) {
        Hashtable<Integer, String> students = new Hashtable<Integer, String>();
        String[] arr = new String[5];
        arr[0] = "Bob 16";
        arr[1] = "Arin 17";
        arr[2] = "Cecilia 15";
        arr[3] = "Cj 18";
        arr[4] = "Jess 19";

        for (int idx = 0; idx < arr.length; idx++) {
            String[] words = arr[idx].split(" ");
            System.out.println(words[1]);
            students.put(Integer.parseInt((words[1])), words[0]);
        }

        Hashtable<Integer, String> sorted = new Hashtable<Integer, String>();
        sorted.putAll(students);

        for (Map.Entry entry : students.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
        }
             
    }
}
