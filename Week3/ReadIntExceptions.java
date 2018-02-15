import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

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
    }
}