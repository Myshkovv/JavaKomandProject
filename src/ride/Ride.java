package ride;

import user.Client;
import user.Driver;

public class Ride {

    private int Id;
    private Client client;
    private Driver driver;

    public int getId() {
        return Id;
    }

    public void setId(int rideId) {
        this.Id = rideId;
    }
}
