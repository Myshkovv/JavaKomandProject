package MapService;


public class TripTiming implements Timing{

    private Coordinate coordinate1 = new RandomCoordinate();
    private Coordinate coordinate2;
    private int averageSpeed;
    private DistanceCalculation len = new CoordinateCalculation(coordinate1, coordinate2);
    private int length = len.distance();

    public TripTiming(Coordinate coordinate1, Coordinate coordinate2, int averageSpeed){
        this.averageSpeed = averageSpeed;
        this.coordinate2 = coordinate2;
        this.coordinate1 = coordinate1;
    }

    @Override
    public int time(){
        int timeOfRide = length / averageSpeed;
        return timeOfRide;
    }

    public int getAverageSpeed(){
        return averageSpeed;
    }
}
