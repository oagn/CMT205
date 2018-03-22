
public class BufferTest {
	public static void main( String[] args )
	{
		// create a new buffer
		Buffer bufferInst = new Buffer();
		// create a Producer thread
		Producer prov = new Producer(bufferInst);
		// create new Consumer thread
		Consumer cons = new Consumer(bufferInst);
		// start the threads
		prov.start();
		cons.start();
	}
}