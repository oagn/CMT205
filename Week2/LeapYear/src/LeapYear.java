
public class LeapYear {
	// Decide whether a given year is a leap year
	 public static void main(String[] args)
	 {
		 int year = 2100;
		 boolean isLeapyear;
		 if((year%100) == 0)
		 {
			 isLeapyear = ((year&4) == 0);
		 }
		 else isLeapyear = ((year%400) == 0);
		 
		 if(isLeapyear)
		 {
			 System.out.println( year+" is a leap year" );
		 }
		 else 
		 {
			 System.out.println( year+" is NOT a leap year" );
		 }
	 }

}
