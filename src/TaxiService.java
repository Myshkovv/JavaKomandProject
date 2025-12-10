import java.util.List;

public class TaxiService {

    private User[] users;
    private Driver[] drivers;
    private Client[] clients;
    private Ride[] rides;
    private int lenUsers;
    private int lenDrivers;
    private int lenClients;
    private int lenRides;

    public TaxiService(User[] users, Driver[] drivers, Client[] clients, Ride[] rides){
        this.users = users;
        this.drivers = drivers;
        this.clients = clients;
        this.rides = rides;
        this.lenUsers = this.users.length;
        this.lenDrivers = this.drivers.length;
        this.lenClients = this.clients.length;
        this.lenRides = this.rides.length;
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

    public void addUser(User newUser){
        User[] newUsers = new User[lenUsers+1];
        for (int i = 0; i < lenUsers; i++) {
            newUsers[i] = users[i];
        }
        newUsers[lenUsers] = newUser;
        users = newUsers;

        if (newUser instanceof Driver driver) {
            addDriver(driver);//Не знал об это, идея помогла сократить код)
        } else if (newUser instanceof Client client) {
            addClient(client);
        }

    }

    public void addDriver(Driver newDriver){
        Driver[] newDrivers = new Driver[lenDrivers+1];
        for (int i = 0; i < lenDrivers; i++) {
            newDrivers[i] = drivers[i];
        }
        newDrivers[lenUsers] = newDriver;
        drivers = newDrivers;
    }

    public void addClient(Client newClient){
        Client[] newClients = new Client[lenClients+1];
        for (int i = 0; i < lenClients; i++) {
            newClients[i] = clients[i];
        }
        newClients[lenUsers] = newClient;
        clients = newClients;
    }

    public void addRide(Ride newRide){
        Ride[] newRides = new Ride[lenRides+1];
        for (int i = 0; i < lenRides; i++) {
            newRides[i] = rides[i];
        }
        newRides[lenUsers] = newRide;
        rides = newRides;
    }

    public User findUserById(int id) {
        for (int i = 0; i < lenUsers; i++) {
            if (users[i].getId() == id) {
                return users[i];
            }
        }
        return null;
    }
    public Client findClientById(int id) {
        for (int i = 0; i < lenClients; i++) {
            if (clients[i].getId() == id) {
                return clients[i];
            }
        }
        return null;
    }

    public Driver findDriverById(int id) {
        for (int i = 0; i < lenDrivers; i++) {
            if (drivers[i].getId() == id) {
                return drivers[i];
            }
        }
        return null;
    }

    public Ride findRideById(int id) {
        for (int i = 0; i < lenRides; i++) {
            if (rides[i].getId() == id) {
                return rides[i];
            }
        }
        return null;
    }

    /**
     * ДОПОЛНИТЬ
     */
    public void displayUsers() {
        System.out.println("\n=== ВСЕ ПОЛЬЗОВАТЕЛИ (" + lenUsers + ") ===");
        for (int i = 0; i < lenUsers; i++) {
            System.out.println(users[i].getId() + ": " + users[i].getName());
        }
    }
    /**
     * ДОПОЛНИТЬ
     */
    public void displayDrivers() {
        System.out.println("\n=== ВСЕ ПОЛЬЗОВАТЕЛИ (" + lenDrivers + ") ===");
        for (int i = 0; i < lenDrivers; i++) {
            System.out.println(drivers[i].getId() + ": " + drivers[i].getName());
        }
    }
    /**
     * ДОПОЛНИТЬ
     */
    public void displayClients() {
        System.out.println("\n=== ВСЕ ПОЛЬЗОВАТЕЛИ (" + lenClients + ") ===");
        for (int i = 0; i < lenClients; i++) {
            System.out.println(clients[i].getId() + ": " + clients[i].getName());
        }
    }
    /**
     * ДОПОЛНИТЬ
     */
    public void displayRides() {
        System.out.println("\n=== ВСЕ ПОЛЬЗОВАТЕЛИ (" + lenRides + ") ===");
        for (int i = 0; i < lenRides; i++) {
            System.out.println(rides[i].getId() + ": ");
        }
    }








    // и дальше дохрена функций

}
