package ride;

import user.Client;
import user.Driver;

public class Ride {

    private int id;
    private static int nextid = 1;
    private Client client;
    private Driver driver;
    private String startAdress;
    private String endAdress;

    public Ride(Client client, Driver driver, String startAdress, String endAdress){

        this.client = client;
        this.driver = driver;
        this.startAdress = startAdress;
        this.endAdress = endAdress;
        this.id = nextid;
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
        return startAdress;
    }

    public String getEndAdress() {
        return endAdress;
    }
}
