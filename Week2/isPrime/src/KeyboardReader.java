import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class KeyboardReader
{
   // constructor for KeyboardReader
   public KeyboardReader( InputStream inStream )
   {
      InputStreamReader input = 
                      new InputStreamReader( inStream );
      reader = new BufferedReader( input );
   }
   // method to read a line from the input stream
   public String readLine()
   {
      String inputLine = "";
      try
      {
         inputLine = reader.readLine();
      } 
      catch ( IOException ioe )
      {
         System.out.println( ioe );
         System.exit( 1 );
      }
      return inputLine;
   }
   // instance variable
   private BufferedReader reader;
}
