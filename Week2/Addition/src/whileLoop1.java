
public class whileLoop1 {
	// For loop to add all of the numbers from 1 to 10
	public static void main(String[] args) {
		int theSum = 0;
		int i = 2;
		while (i<17)
		{
			theSum += i;
			 i+=2;
		}
		System.out.println( "The sum 2+4+6+8+10+12+14+16 is "+theSum );
	}
}
