package ride;

import MapService.Address;
import MapService.ArrayOfAddress;
import MapService.CoordinateCalculation;
import MapService.MakeAddress;
import car.Tariff;
import user.Client;
import user.Driver;

import java.net.spi.InetAddressResolver;

public class Ride {

    private int id;
    private static int nextid = 1;
    private Client client;
    private Driver driver;
    private Address startAdress;
    private Address endAdress;
    private String tariff;
    private int distance;
    private int tariffPrice;
    private ArrayOfAddress addressArray = new ArrayOfAddress();
    private int rideTime;


    public Ride(Client client, Driver driver, String startAdress, String endAdress){

        MakeAddress mk = new MakeAddress(addressArray);
        this.client = client;
        this.driver = driver;
        this.startAdress = mk.createAddress(startAdress, "Казань");
        this.endAdress = mk.createAddress(endAdress, "Казань");
        this.id = nextid;
        this.tariff = driver.getTarif();
        this.tariffPrice = driver.getTarifPrice();
        this.distance = mk.getDistance(this.startAdress, this.endAdress);
        this.rideTime = mk.getTime(this.startAdress, this.endAdress, 60);
        nextid++;
        
    }



    public int getId() {
        return id;
    }

    public void setId(int rideId) {
        this.id = rideId;
    }

    public Client getClient() {
        return client;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getStartAdress() {
        return startAdress.getFullAddress();
    }

    public String getEndAdress() {
        return endAdress.getFullAddress();
    }

    public String getTariff() {
        return tariff;
    }

    public int getDistance() {
        return distance;
    }

    public int getRideTime() {
        return rideTime;
    }
}
