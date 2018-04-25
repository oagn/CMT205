// The Truck class definition
public class Truck extends Vehicle 
{

   // Private member variables
	private double loadCapacity;
	private int towingCapacity;

   	// Constructors
   	public Truck( String manufacturer, int noCylinders, Person owner, double loadCapacity, int towingCapacity ){
   		super( manufacturer, noCylinders, owner );
      	this.loadCapacity = loadCapacity;
      	this.towingCapacity = towingCapacity;
   }

   // Public getter and setter for private variables
   public double getLoadCapacity() {
      return loadCapacity;
   }

   public int getTowingCapacity() {
      return towingCapacity;
   }

   public void setLoadCapacity() {
      this.loadCapacity = loadCapacity;
   }

   public void setTowingCapacity() {
      this.towingCapacity = towingCapacity;
   }

   // Override toString() method
   public String toString() {
      return getManufacturer() + "\t(" + getNoCylinders() + ")\n" + getOwner() + "\n" + "Vehicle Type: Truck\n" + "Load Capacity: " + loadCapacity + "\n"+ "Towing Capacity: " + towingCapacity + "\n\n";
   }
}