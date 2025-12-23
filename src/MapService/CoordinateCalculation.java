public class CoordinateCalculation implements DistanceCalculation{

    private Coordinate coordinate1;
    private Coordinate coordinate2;

    public CoordinateCalculation(Coordinate coordinate1, Coordinate coordinate2){
        this.coordinate1 = coordinate1;
        this.coordinate2 = coordinate2;
    }

    @Override
    public int distance(){
        int dx = coordinate2.getX() - coordinate1.getX();
        int dy = coordinate2.getY() - coordinate1.getY();
        return (int) Math.sqrt((dx*dx) + (dy*dy));
    }
}
