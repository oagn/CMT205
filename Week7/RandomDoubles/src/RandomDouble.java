import java.util.Random;

//Generate 20 random doubles between 4 and 8
public class RandomDouble {
	public static void main( String[] args ){
	   Random generator = new Random();
	   for ( int i = 1; i <= 16; i++ )
	   {
			 Double number = generator.nextDouble()*4. + 4.;
	      System.out.print( number + " " );
	   }
	   System.out.println( "" ); 
	}
}