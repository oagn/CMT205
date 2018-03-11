public class Truck extends Vehicle {
    // Private member variables
    private double loadCapacity; //In tonnes
    private int towingCapacity; //In kilograms

    public Truck( ) {
       super();              // invoke superclass' constructor Circle()
       loadCapacity = 0.0;
       towingCapacity = 0;
    }

    public Truck( String manifacturer, int cylinders, Person owner, Double loadCapacity, int towingCapacity ) {
       super(manifacturer, cylinders, owner);              // invoke superclass' constructor Circle()
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

    public void setLoadCapacity( double loadCapacity) {
       this.loadCapacity = loadCapacity;
    }

    public void setTowingCapacity( int towingCapacity ) {
       this.towingCapacity = towingCapacity;
    }

    // Override toString() method
    public String toString() {
       return getManifacturer() + "\t(" + getCylinders() + ")\n" + getOwner() + "\n" + "Vehicle Type: Truck\n" + "Load Capacity: " + loadCapacity + "\n"+ "Towing Capacity: " + towingCapacity + "\n\n";
    }
}
