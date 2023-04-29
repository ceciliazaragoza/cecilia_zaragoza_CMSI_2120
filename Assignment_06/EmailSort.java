
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class EmailSort {

    Map<String,ArrayList<String>> rawmp = new TreeMap<String,ArrayList<String>>();

    public EmailSort(String file) {
        try {
                Scanner scan = new Scanner(new File(file));
                
        
                while (scan.hasNextLine()) {
                        String input = scan.nextLine();
                        Email d_email = new Email(input);
        
                        String name = d_email.parseEmailName();
                        String company = d_email.parseCompanyName();
        
                        if (rawmp.containsKey(company)) 
                        {
                                ArrayList<String> al = rawmp.get(company);
                                al.add(name);
                                Collections.sort(al);
                                rawmp.put(company,al);
                        }  
                        else 
                        {         
                                ArrayList<String> al = new ArrayList<String>();
                                al.add(name);
                                rawmp.put(company,al); 
                        }
                }
                scan.close();
        } catch (FileNotFoundException fnf) {
                System.err.println("Sorry file could not be found.");
        }
    }

    public String getDocument() {
        String document = "";
        for (Map.Entry<String,ArrayList<String>> entry: rawmp.entrySet()) {
                for (int idx = 0; idx < entry.getValue().size(); idx++) {
                        document += entry.getKey() + "\t" + entry.getValue().get(idx);
                        document += "\n";
                }
        }
        return document;
    }

    public void getHistogram() {
        String histogram = "";
        //this is a for each loop
        for (Map.Entry<String,ArrayList<String>> entry: rawmp.entrySet()) {
                histogram += entry.getKey() + "\t| ";
                for (int idx = 0; idx < entry.getValue().size(); idx++) {
                        histogram += "*";
                }
                histogram += "\n";
        }
        System.out.println(histogram);
    }

    public void findAttendee(String name) {
        boolean found = false;
        for (Map.Entry<String, ArrayList<String>> entry : rawmp.entrySet()) {
                for (int idx = 0; idx < entry.getValue().size(); idx++) {
                        if (entry.getValue().get(idx).equals(name)) {
                                found = true;
                                break;
                        }
                        if (entry.getValue().get(idx).split(" ").equals(name)) {
                                found = true;
                                break;
                        }
                }
                if (found) {
                        break;
                }
        }
        if (found) {
                System.out.println(name + " is an attendee!");
        }
        else {
                System.out.println(name + " is not an attendee.");
        }
    }

    public void findAttendee(String name, String company) {
        boolean found = false;
        for (Map.Entry<String, ArrayList<String>> entry : rawmp.entrySet()) {
                if (entry.getKey().equals(company)) {
                        for (int idx = 0; idx < entry.getValue().size(); idx++) {
                                if (entry.getValue().get(idx).equals(name)) {
                                        found = true;
                                        break;
                                }
                                if (name.indexOf(" ") != -1) {
                                        String[] split_name = name.toLowerCase().split(" ");
                                        String[] split_user = entry.getValue().get(idx).toLowerCase().split("\\.");
                                        if (split_name[0].equals(split_user[0]) && split_name[1].equals(split_user[1])) {
                                                found = true;
                                        }
                                }
                        }
                        if (found) {
                                break;
                        }
                }
        }
        if (found) {
                System.out.println(name + " from " + company + " is an attendee!");
        } else {
                System.out.println(name + " from " + company + " is not an attendee.");
        }
    }

    public void tofile() {
        //what should the return type of this be?
    }
}
