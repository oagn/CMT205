// The Journey class definition
public class RoomCarpet {
   // Private member variables
   private RoomDimension size;
   private double carpetCost;

   // Constructors
   public RoomCarpet( RoomDimension size, double carpetCost){
      this.size = size;
      this.carpetCost = carpetCost;
   }

    // Public getter and setter for private variables
   public double getTotalCost() {
      return size.getArea() * carpetCost;
   }

   public String toString() {
      return "Area: " + size.getArea() + "\tCost Per Square Meter:" + carpetCost + "\n";
   }
 
}