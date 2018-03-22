public class HorseTest {
	
	public static void main( String[] args )
	{
		
		// For saving the winner
		int winnerID = -1;
		int winnerSteps = -1;
		int[] results = new int[10];
		
		// create threads
		HorseThread horse1 = new HorseThread(0);
		HorseThread horse2 = new HorseThread(1);
		HorseThread horse3 = new HorseThread(2);
		HorseThread horse4 = new HorseThread(3);
		HorseThread horse5 = new HorseThread(4);
		HorseThread horse6 = new HorseThread(5);
		HorseThread horse7 = new HorseThread(6);
		HorseThread horse8 = new HorseThread(7);
		HorseThread horse9 = new HorseThread(8);
		HorseThread horse10 = new HorseThread(9);
		   
		// Start threads
		horse1.start();
		horse2.start();
		horse3.start();
		horse4.start();
		horse5.start();
		horse6.start();
		horse7.start();
		horse8.start();
		horse9.start();
		horse10.start();
		
		// Wait for all horses to finish
	    try
	    {
	    		// wait for each of the other threads to finish  
	        horse1.join();
	        horse2.join();
	        horse3.join();
	        horse4.join();
	        horse5.join();
	        horse6.join();
	        horse7.join();
	        horse8.join();
	        horse9.join();
	        horse10.join();
	    }
	    catch (InterruptedException e)
	    {
	    }
	    
	    results = HorseThread.getResults();
	    winnerID = indexOfMin(results, 10);
	    winnerSteps = results[winnerID];
	    
		System.out.println("\nAnd the winner is: \nHorse ID: " + winnerID + " with " + winnerSteps + " steps!");
	}
	
	private static int indexOfMin(int[] a, int cnt) {
		int loc = 0;
		int min = a[loc];
		for (int i = 1; i < cnt; i++) {
		    	if (a[i] < min) {
		    		min = a[i];
		    		loc = i;
		    	}
		}
		return loc;
	}

}
