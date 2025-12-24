package service;

public interface DisplayObjectService {
    void displayUsers();
    void displayDrivers();
    void displayClients();
    void displayRides();
    void displayMostActiveClient();
    void displayMostActiveDriver();
    void displayUsersByName(String name);
    void displayDriverByCar(String number);
    void displayDeleteUser(int userId);
    void displayUserRides(int userId);
    void displayUser(int userId);
    void displayClient(int clientId);
    void displayDriver(int driverId);
    void displayRide(int rideId);


}
