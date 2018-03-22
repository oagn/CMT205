public class Buffer{
	//Variables
	private int head;
	private int count;
	private int[] values = new int[BUFFER_SIZE];
	//Constants
	private static final int BUFFER_SIZE = 10;
	
	public Buffer() {	
		head = 0;
		count = 10;
	}
	
	public synchronized int get() {
		int returnVal;
		if( isEmpty() ) {
			throw new RuntimeException("The buffer is empty!");
		}
		else {
			returnVal = values[head];
			values[head] = 0;
			head = (head + 1) % BUFFER_SIZE;
			count += 1;
			
			return returnVal;
		}
	}
	
	public synchronized void put(int val) {
		int pos = (head + count) % BUFFER_SIZE;
		if( isFull() ) {
			throw new RuntimeException("The buffer is full!");
		}
		else{
			values[pos] = val;
			count -= 1;
		}
	}
	
	public Boolean isEmpty() {
		if(count == 10) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean isFull() {
		if(count == 0) {
			return true;
		}
		else {
			return false;
		}
	}

}
