
public class Client extends User {

    private int id;
    private String name;
    private Ride[] rides;
    private int countRides;
    private static int nextId = 1;

    public Client(String name,  String phoneNumber, String mail) {
        super(name, phoneNumber, mail);
        this.id = nextId++;
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
