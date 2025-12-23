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
                System.out.println("Создан и добавлен новый адрес: " + newAddress);
                return newAddress;
            }
            attempts++;
        }
        System.out.println("Не удалось создать уникальный адрес" + street + "," + city);
        return null;
    }
}
