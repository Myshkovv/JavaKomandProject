
public class Client extends User {

    private int id;
    private String name;
    private Ride[] rides;
    private int countRides;

    public Client(String name) {
        super(name);
        this.id = id;
    }

    public Ride[] getRides() {
        return rides;
    }

    public void setRides(Ride[] rides) {
        this.rides = rides;
    }

    public int getCountRides() {
        return countRides;
    }

    public void setCountRides(int countRides) {
        this.countRides = countRides;
    }
}
