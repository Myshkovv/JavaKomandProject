package service;

import ride.Ride;
import user.Client;
import user.Driver;
import user.User;

public interface FindObjectByIdService {
    User findUserById(int id);
    Client findClientById(int id);
    Driver findDriverById(int id);
    Ride findRideById(int id);
}
