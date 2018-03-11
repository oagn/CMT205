import java.util.Scanner;

public class RoomTest{

    public static void main( String[] args ){

                System.out.println("Please enter the dimensions of your room and carpet price per square meter. Separate values with spaces.");
                System.out.print( "Use format [m],[m],[£/m^2]. For example: 4 6 12: \n" );
                Scanner in = new Scanner(System.in);
                int length = in.nextInt();
                int width = in.nextInt();
                int cost = in.nextInt();
                RoomDimension dimensions = new RoomDimension(length, width);
                RoomCarpet carpet = new RoomCarpet(dimensions, cost);

                System.out.print(carpet);
    }
}
