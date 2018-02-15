import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class isPrimeInput {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader( System.in ) );
		int n = -1;
		String inputLine = ""; 
		
		// get number from user
		System.out.println("Enter a number");
		try
		{
			inputLine = reader.readLine();
		}
		catch(IOException ioe)
		{
			 System.out.println( ioe );
	         System.exit( 1 );
		}
		try
		{
			int nin = Integer.parseInt( inputLine );
			n=nin;
		}
		catch ( NumberFormatException ne )
		{
			System.out.println( "Not a number!" );
			System.exit( 2 );
		}

		
		boolean aPrime = true;
	    //check if n is a multiple of 2
	    if (n<2 || (n!=2 && n%2==0)) aPrime = false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            aPrime = false;
	    }
	    if(aPrime)
		 {
			 System.out.println( n+" is a prime number" );
		 }
		 else 
		 {
			 System.out.println( n+" is NOT a prime number" );
		 }
	}
}
