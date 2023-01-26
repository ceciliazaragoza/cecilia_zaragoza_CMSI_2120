import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class FileStreamDemo {
    public static void main(String[] args) {
        try {
            FileInputStream in = null;
            FileOutputStream out = null;
            in = new FileInputStream(args[0]);
            out = new FileOutputStream(args[1]);

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException fnf) {
            System.err.println("Sorry couldn't find the file.");
        } catch (IOException io) {
            System.err.println("Sorry something went wrong with input/output.");
        }
    }
}