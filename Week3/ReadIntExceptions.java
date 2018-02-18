/* Week 3, exercise 10:
- a) Run program - runs OK
- b) Rename the file an_integer.txt to oops.txt - File not found!
- c) Replace the text in the file with 1234five6789
    Modify ReadIntExceptions to add another catch block that
    handles this exception and prints out an appropriate message.
*/

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class ReadIntExceptions {
    public static void main( String[] args ) {
        try {
            String filename = "an_integer.txt";
            File f = new File( filename );
            Scanner in = new Scanner( f );
            int i = in.nextInt();
            System.out.println( i );
        }
        catch ( FileNotFoundException ex ) {
            System.out.println( "File not found!" );
        }
        catch ( InputMismatchException ex ) {
            System.out.println( "Input mismatch, not an integer!" );
        }
    }
}
