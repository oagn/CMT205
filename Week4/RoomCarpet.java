public class RoomCarpet{
    private double carpetCost;
    private RoomDimension size;

    public RoomCarpet( RoomDimension dim, double cost ){
        size = dim;
        carpetCost = getTotalCost(cost);
    }

    public double getTotalCost( double carpetCost ){
        return size.getArea()*carpetCost;
    }

    @Override
    public String toString( ){
        return "Size: " + size + ", Cost: " + carpetCost + "\n";
    }
}
