
public class Driver extends User {

    private int id;
    private String name;
    private Car car;
    private Ride[] rides;
    private int countRides;

    public Driver(String name, String phoneNumber, String mail, Car car) {
        super(name, phoneNumber, mail);
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getCountRides() {
        return countRides;
    }

    public void setCountRides(int countRides) {
        this.countRides = countRides;
    }
}
