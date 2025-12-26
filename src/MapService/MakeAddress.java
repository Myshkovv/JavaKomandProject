package MapService;


import java.util.Random;

public class MakeAddress {
    private static final Random random = new Random();
    private final ArrayOfAddress addressArray;

    public MakeAddress(ArrayOfAddress addressArray){
        this.addressArray = addressArray;
    }

    public Address createAddress(String street, String city) {
        int maxAttempts = 50;
        int attempts = 0;
        while (attempts < maxAttempts){
            Coordinate coordinate = new RandomCoordinate();
            Address newAddress = new Address(street, city, coordinate);
            if (!addressArray.contains(newAddress)){
                addressArray.addAddress(newAddress);
                System.out.println("Создан и добавлен новый адрес: " + newAddress.getFullAddress());
                return newAddress;
            }
            attempts++;
        }
        System.out.println("Не удалось создать уникальный адрес" + street + "," + city);
        return null;
    }

    public int getDistance(Address start, Address end){
        Coordinate coordinateStart = start.getCoordinate();
        Coordinate coordinateEnd = end.getCoordinate();
        DistanceCalculation distance = new CoordinateCalculation(coordinateStart, coordinateEnd);
        return distance.distance();
    }

    public int getTime(Address start, Address end, int averageSpeed){
        Coordinate coordinateStart = start.getCoordinate();
        Coordinate coordinateEnd = end.getCoordinate();
        Timing time = new TripTiming(coordinateStart, coordinateEnd, averageSpeed);
        return time.time();
    }
}
