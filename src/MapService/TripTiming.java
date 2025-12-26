package MapService;


public class TripTiming implements Timing{

    private Coordinate coordinate1;
    private Coordinate coordinate2;
    private int averageSpeed;
    private DistanceCalculation len;
    private int length;

    public TripTiming(Coordinate coordinate1, Coordinate coordinate2, int averageSpeed){
        this.averageSpeed = averageSpeed;
        this.coordinate2 = coordinate2;
        this.coordinate1 = coordinate1;
        this.len = new CoordinateCalculation(coordinate1, coordinate2);
        this.length = this.len.distance();
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
