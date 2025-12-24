public class Address {
    private final String street;
    private final String city;
    private final Coordinate coordinate;

    public Address(String street, String city, Coordinate coordinate) {
        this.street = street;
        this.city = city;
        this.coordinate = coordinate;
    }

    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public Coordinate getCoordinate() {
        return coordinate;
    }
}
