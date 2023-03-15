package Labs;
/*
 * Wk 2-1 Lab: I/O Character Stream & Exception
 * Read through the character stream documentation and write 2 classes of your choice:
 * The first should read from a file
 * The second should write to a file
 * Write a class of your choice that utilizes custom exception. It should not look exactly like the example but can be similar.
 * Upload a java file. Note you can only submit once.
 */
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

//this class writes to a file
public class Wk_2_1_Lab_Write {
    public static void main(String[] args) throws IOException {
        try {
            FileWriter out = new FileWriter(args[0]);
            String response = System.console().readLine("How many lines do you want to write to the file? ");
            int lines = Integer.parseInt(response);
            if (lines < 0) { //throw is when we want to manually throw an exception ourselves
                out.close();
                throw new IllegalArgumentException("You can't write a negative number of lines.");
            } else if (lines >= 1000000000) {
                out.close();
                throw new IllegalArgumentException("That is too many lines.");
            }
            
            int repeat = 0;
            while (repeat < lines) {
                String answer = System.console().readLine();
                out.write(answer + "\n");
                repeat++;
            }
            
            if (out != null) {
                out.close();
            }
        } catch(IllegalArgumentException e) {
            System.err.println(e.getLocalizedMessage());
        } catch (FileNotFoundException fnf) {
            System.err.println("Sorry file could not be found.");
        } catch (IOException io) {
            System.err.println("Something went wrong with input/output.");
        }
    }
}