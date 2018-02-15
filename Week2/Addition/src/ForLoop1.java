
public class ForLoop1 {
	// For loop to add all of the numbers from 1 to 10
	public static void main(String[] args) {
		int theSum = 0;
		for (int i=1; i<11; i++)
		{
			theSum += i;
		}
		System.out.println( "The sum of the integers from 1-10 is "+theSum );
	}
}
