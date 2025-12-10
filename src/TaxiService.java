import java.util.List;

public class TaxiService {

    private User[] users;
    private Driver[] drivers;
    private Client[] clients;
    private Ride[] rides;

    public TaxiService(User[] users, Driver[] drivers, Client[] clients, Ride[] rides){
        this.users = users;
        this.drivers = drivers;
        this.clients = clients;
        this.rides = rides;
        int lenUsers = this.users.length;
        int lenDrivers = this.drivers.length;
        int lenClients = this.clients.length;
        int lenRides = this.rides.length;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Driver[] getDrivers() {
        return drivers;
    }

    public void setDrivers(Driver[] drivers) {
        this.drivers = drivers;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    public Ride[] getRides() {
        return rides;
    }

    public void setRides(Ride[] rides) {
        this.rides = rides;
    }

    public void addUser(User user){
        
    }



    // и дальше дохрена функций

}
