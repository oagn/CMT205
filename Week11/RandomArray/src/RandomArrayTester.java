import java.util.Random;

/* Task 3
 * Create an array list with 10 random numbers, 
 * the use the command pattern to:
 * a. print array list
 * b. multiply each element by 2
 * c. print array list again
 */

public class RandomArrayTester{
	public  static void main(String[] args) {
		// create a collection
		RandomArray  collection = new RandomArray();
		// add elements to the collection
		Random rand = new Random();
		for (int j = 0; j<10; j++)
        {
            double pick = rand.nextDouble();
            collection.add(pick);
        }
		
		// print out the elements of the collection
		collection.map(new Command() {
		    public void execute(Object data) {
		      System.out.println(data);
		   }
		});
		collection.map(new Command() {
		    public void execute(Object data) {
		      ;
		   }
		});
		collection.map(new Command() {
		    public void execute(Object data) {
		      System.out.println(data);
		   }
		});
	}
}
