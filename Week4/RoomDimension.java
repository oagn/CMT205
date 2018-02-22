public class RoomDimension{
    private double length;
    private double width;

    public RoomDimension( double len, double w ){
        length = len;
        width = w;
    }

    public double getArea( ){
        return length*width;
    }

    @Override
    public String toString( ){
        return length + " x " + width;
    }
}
