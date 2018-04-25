// The Vehicle class definition
public class Vehicle
{
   // Private member variables
	private String manufacturer;
	private int noCylinders;
	private Person owner;


   // Constructors
   public Vehicle( String manufacturer, int noCylinders ){
      this.manufacturer = manufacturer;
      this.noCylinders = noCylinders;
   }

   public Vehicle( String manufacturer, int noCylinders, Person owner ){
      this.manufacturer = manufacturer;
      this.noCylinders = noCylinders;
      this.owner = owner;
   }

   // Public getter and setter for private variables
   public String getManufacturer() {
      return manufacturer;
   }

   public int getNoCylinders() {
      return noCylinders;
   }

   public Person getOwner() {
      return owner;
   }

   public void setManufacturer( String manufacturer ) {
      this.manufacturer = manufacturer;
   }

   public void setNoCylinders() {
      this.noCylinders = noCylinders;
   }

   public void setOwner() {
      this.owner = owner;
   }

   // Override toString() method
   public String toString() {
      return manufacturer + "(" + noCylinders + ")\n" + owner + "\n\n";
   }
}
