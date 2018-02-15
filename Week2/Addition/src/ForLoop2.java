
public class ForLoop2 {
	// For loop to add all of the numbers from 1 to 10
	public static void main(String[] args) {
		int theSum = 0;
		for (int i=2; i<17; i+=2)
		{
			theSum += i;
		}
		System.out.println( "The sum 2+4+6+8+10+12+14+16 is "+theSum );
	}
}
