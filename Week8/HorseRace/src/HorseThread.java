/**
 * HorseThread class:
 *
 * <p>Bugs:
 *
 * @author AO
 */

import java.util.Random;

public class HorseThread extends Thread{

	// Instance variables
	private int horseID;
	private int dist;
	private int steps;
	// Constants
	private static final int DISTANCE = 1000;
	private static final int DELAY = 10;

	/**
	 * HorseThread constructor
	 *
	 * @param horseID The ID of the horse 
	 */
	public HorseThread( int horseID ) {
		this.horseID = horseID;
		dist = 0;
		steps = 0;
	}
	
	/**
	 * this method is executed when the thread is started
	 *
	 */
	public void run()
	{
		Random generator = new Random();
		try
		{
			while( dist <= DISTANCE && ! isInterrupted() )
			{
				// Move between 1 and 6 meters
		        dist += generator.nextInt(6) + 1;
		        steps += 1;
		        // sleep for 10 milliseconds
		        Thread.sleep( DELAY );
			}
			System.out.println("Horse ID: "+ horseID + " Steps: " + steps);
		}
		// exception generated if sleeping thread is
		// interrupted
		catch ( InterruptedException ie )
		{
			System.out.println("Interrupted while sleeping" );
		}
	}
	
}

