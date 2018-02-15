public class isPrime {
	//Test whether a number is a prime//
	public static void main(String[] args) {
		int n = 7897;
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