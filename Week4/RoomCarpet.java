public class RoomCarpet{
    private double carpetCost;
    private RoomDimension size;

    public RoomCarpet( RoomDimension dim, double cost ){
        size = dim;
        carpetCost = cost;
    }

    public double getTotalCost( ){
        return size.getArea()*carpetCost;
    }

    @Override
    public String toString( ){
        return "Size: " + size + ", Cost: " + carpetCost;
    }
}
