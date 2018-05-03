// test method for singleton class
// should show that the singleton is not created until it is needed by the SingletonTester

public class SingletonTester {
	public static void main(String[] args) {
		// Creating an instance of the singleton class
		Singleton instance1 = Singleton.instance();
		
		// Calling the instance method again and assigning this to a different variable
		Singleton instance2 = Singleton.instance();
		
		// Printing hash codes to check that these are actually the same instance of the Singleton class
		System.out.println(instance1.hashCode());
		System.out.println(instance2.hashCode());
	}
}
