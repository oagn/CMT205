// A test driver program for Truck class
public class TestTruck {
   public static void main(String[] args) {

      // Test Truck, default
      Truck tr0 = new Truck( );
      System.out.println( tr0 );

      // Test Truck
      Truck tr1 = new Truck( "Mazda", 8, new Person( "Karen Jones", "100 New Street, Bergen, 5000, Norway", "+44 08154923009" ), 40.0, 600 );
      System.out.println( tr1 );

      // Substitute a subclass instance to its superclass reference - UPCASTING
      Vehicle veh1 = new Truck( "Mercedes Benz", 16, new Person( "Tim Smith", "33 Bronze Drive, Cathays, Cardiff, CF19 8BZ", "+44 07913876245"), 165.5, 1500);
      System.out.println( veh1 );

      // Test Vehicle
      Vehicle veh2 = new Vehicle("Benzo", 8, new Person("Agnethe", "My address", "55941908"));
      System.out.println( veh2 );
   }
}
