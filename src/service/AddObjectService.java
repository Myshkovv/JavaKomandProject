package service;

import ride.Ride;
import user.Client;
import user.Driver;
import user.User;

public interface AddObjectService {
    void addUser(User newUser);
    void addDriver(Driver newDriver);
    void addClient(Client newClient);
    void addUserStory(User user);
    void addRide(Ride newRide);


}
