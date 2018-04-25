// A test driver program for Truck class
public class TestTruck {
   public static void main(String[] args) {

      // Test Truck
      Truck tr1 = new Truck( "Mercedes Benz", 16, new Person( "Tim Smith", "33 Bronze Drive, Cathays, Cardiff, CF19 8BZ", "+44 07913876245"), 165.5, 1500);
      System.out.println( tr1 );

      // Substitute a subclass instance to its superclass reference - UPCASTING
      Vehicle veh1 = new Truck( "Scania", 20, new Person( "Roger Wilks", "19a Peace Towers, Bristol, BR22 5SV", "01225864253"), 186.3, 2200);
      System.out.println( veh1 );      
   }
}