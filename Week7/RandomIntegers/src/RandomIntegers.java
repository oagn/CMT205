import java.util.Random;

//Generate 16 integers between 3 and 6
public class RandomIntegers {
	public static void main( String[] args ){
	   Random generator = new Random();
	   for ( int i = 1; i <= 16; i++ )
	   {
			 int number = generator.nextInt(3) + 3;
	      System.out.print( number + " " );
	   }
	   System.out.println( "" ); 
	}
}


