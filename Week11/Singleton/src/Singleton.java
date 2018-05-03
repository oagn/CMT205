// Q: 	Why is lazy initialization preferred in some cases?

/* A: 	Lazy initialization frees up memory up until the point when a resource
* 		is needed. 
* 		When we use the Singleton design pattern we make initialization
* 		of the object a hidden (private constructor) method. 
* 		if a user does not need to use the singleton object until at a later stage
* 		we might want to use lazy initialization. 
*/

public class Singleton
{
	private static Singleton instance = new Singleton();
	private Singleton() {};
	public static Singleton instance() { 
		if (instance == null){ //if there is no instance available... create new one
            instance = new Singleton();
		}
		
		return instance; 
	}
}
