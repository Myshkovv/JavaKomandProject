package service;

import MapService.Address;
import car.Car;
import ride.Ride;
import user.Client;
import user.Driver;

public interface RegisterObjectService {
    Client registerClient(String name, String phoneNumber, String mail);
    Driver registerDriver(String name, String phoneNumber, String mail, Car car);
    Ride registerRide(Client client, Driver driver, String startAdress, String endAdress);
}
