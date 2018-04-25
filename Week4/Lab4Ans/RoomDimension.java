// The RoomDimension class definition
public class RoomDimension {
   // Private member variables
   private double length;
   private double width;

   // Constructors
   public RoomDimension(double length, double width){
      this.length = length;
      this.width = width;
   }

    // Public getter and setter for private variables
   public double getArea() {
      return length * width;
   }

   public String toString() {
      return "The room measures: " + length + " long by " + width + " wide";
   }
 
}