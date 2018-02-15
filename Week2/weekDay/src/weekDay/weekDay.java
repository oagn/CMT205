package weekDay;

public class weekDay {
	// Map numbers (0-6) to week days
	public static void main(String[] args) {
		int weekDNum = 0;
		String weekDStr;
		
		switch (weekDNum)
		{
			case 0: weekDStr = "Monday"; break;
			case 1: weekDStr = "Tuesday"; break;
			case 2: weekDStr = "Wednesday"; break;
			case 3: weekDStr = "Thursday"; break;
			case 4: weekDStr = "Friday"; break;
			case 5: weekDStr = "Saturday"; break;
			case 6: weekDStr = "Sunday"; break;
			default: weekDStr = ""; break;
		}
		System.out.println( weekDStr );
	}

}
