// The Vehicle class definition
public class Vehicle
{
    // Private member variables
    private String manifacturer;
    private int cylinders;
    private Person owner;

    // Constructors (overloaded)
    public Vehicle( ) {
        manifacturer = "";
        cylinders = 0;
        owner = new Person();
    }

    public Vehicle( String manifacturer, int cylinders ) {
         this.manifacturer = manifacturer;
         this.cylinders = cylinders;
         this.owner = new Person();
     }

     public Vehicle( String manifacturer, int cylinders, Person owner ) {
         this.manifacturer = manifacturer;
         this.cylinders = cylinders;
         this.owner = owner;
     }

     public String getManifacturer( ) {
         return manifacturer;
     }

     public int getCylinders( ) {
         return cylinders;
     }

     public Person getOwner( ) {
         return owner;
     }

     public void setManifacturer(String manifacturer) {
         this.manifacturer = manifacturer;
     }

     public void setCylinders(int cylinders) {
         this.cylinders = cylinders;
     }

     public void setOwner(Person owner) {
         this.owner = owner;
     }

     @Override
     public String toString( ) {
        return manifacturer + "\t(" + cylinders + ")\n" + owner + "\n";
     }
}
