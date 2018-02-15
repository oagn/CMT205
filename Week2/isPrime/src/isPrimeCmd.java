public class isPrimeCmd {
	public static void main(String[] args) {
		
		int n = -1;

		if ( args.length > 1 )
		{
			System.out.println( "Too many arguments" );
			System.exit( 1 );
		}
		else if( args.length == 0 )
		{
			System.out.println( "No arguments supplied" );
			System.exit( 1 );
		}
		else
		{
		
			try
			{
				int nin = Integer.parseInt( args[0] );
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
}
