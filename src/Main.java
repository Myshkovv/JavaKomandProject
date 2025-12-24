import ride.Ride;
import service.ConsoleMenu;
import service.TaxiService;
import user.Client;
import user.Driver;
import user.User;

public class Main {

    public static void main(String[] args) {

        TaxiService taxiService = new TaxiService(new User[0], new Driver[0], new Client[0], new Ride[0]);

        ConsoleMenu consoleMenu = new ConsoleMenu(taxiService);
        consoleMenu.start();
    }
}