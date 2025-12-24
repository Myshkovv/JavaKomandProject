package ride;

import user.Client;
import user.Driver;

public class Ride {

    private int Id;
    private Client client;
    private Driver driver;
    private String startAdress;
    private String endAdress;

    public Ride(Client client, Driver driver, String startAdress, String endAdress){

        this.client = client;
        this.driver = driver;
        this.startAdress = startAdress;
        this.endAdress = endAdress;

    }



    public int getId() {
        return Id;
    }

    public void setId(int rideId) {
        this.Id = rideId;
    }

    public Client getClient() {
        return client;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getStartAdress() {
        return startAdress;
    }

    public String getEndAdress() {
        return endAdress;
    }
}
