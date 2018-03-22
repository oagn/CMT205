import java.util.Random;

public class Consumer extends Thread{
	
	//Producer constructor
	public Consumer(Buffer bufferInst) {
		this.bufferInst = bufferInst;
	}
	
	// this method is executed when the thread is started
	public void run()
	{
		Random generator = new Random();
		try {
			for (int i = 0; i <= COUNTS && ! isInterrupted(); i++) {
				// put a new number into the buffer
				bufferInst.get();
				// sleep between 50 and 150 ms
				Thread.sleep(generator.nextInt(MAX_DELAY - MIN_DELAY) + MIN_DELAY);
				
			}
		}
	    // exception generated if sleeping thread is
	    // interrupted
	    catch ( InterruptedException ie )
	    {
	    		System.out.println("Interrupted while sleeping" );
	    }
	}
	
	private Buffer bufferInst;
	private static final int MIN_DELAY = 50;
	private static final int MAX_DELAY = 150; 
	private static final int COUNTS = 100;	

}
