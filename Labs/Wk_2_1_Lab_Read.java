package Labs;
/*
 * Wk 2-1 Lab: I/O Character Stream & Exception
 * Read through the character stream documentation and write 2 classes of your choice:
 * The first should read from a file
 * The second should write to a file
 * Write a class of your choice that utilizes custom exception. It should not look exactly like the example but can be similar.
 * Upload a java file. Note you can only submit once.
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

//this class reads from a file
public class Wk_2_1_Lab_Read {
    public static void main(String[] args) throws IOException {
        try {
            FileReader in = new FileReader(args[0]);
            FileWriter out = new FileWriter(args[1]);

            int counter;
            while ((counter = in.read()) != -1) {
                out.write(counter);
            }

            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        
        } catch (FileNotFoundException fnf) {
            System.err.println("Sorry file could not be found.");
        } catch (IOException io) {
            System.err.println("Something went wrong with input/output.");
        } 
    }
}