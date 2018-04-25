import java.util.Scanner;

public class TestCarpet {
   public static void main( String args[] ) {
	Scanner in = new Scanner(System.in);
	System.out.print("Enter length of room: ");
	double length = in.nextDouble();
	System.out.print("Enter width of room: ");
	double width = in.nextDouble();
	System.out.print("Enter price per square metre: ");
	double price = in.nextDouble();

	RoomDimension myRoom = new RoomDimension(length, width);
	RoomCarpet myCarpet = new RoomCarpet(myRoom, price);
	System.out.println("Cost of carpet = £" + myCarpet.getTotalCost() );
   }
}


