package service;

import car.Car;
import ride.Ride;
import user.Client;
import user.Driver;
import user.User;
import user.UserStory;

public class TaxiService {
    private UserStory[] userStories;
    private User[] users;
    private Driver[] drivers;
    private Client[] clients;
    private Ride[] rides;
    private int lenUserStories;
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
        this.userStories = new UserStory[0];
        this.lenUserStories = 0;

//        for (User user : users) {
//            addUserStory(user);
//        }
    }

    public User[] getUsers() {
        return users;
    }

    public Driver[] getDrivers() {
        return drivers;
    }

    public Client[] getClients() {
        return clients;
    }

    public Ride[] getRides() {
        return rides;
    }

    public Client registerClient(String name, String phoneNumber, String mail) {
        Client client = new Client(name, phoneNumber, mail);
        addUser(client);
        return client;
    }

    public Driver registerDriver(String name, String phoneNumber, String mail, Car car) {
        Driver driver = new Driver(name, phoneNumber, mail, car);
        addUser(driver);
        return driver;
    }

    public void addUser(User newUser){
        User[] newUsers = new User[lenUsers+1];
        for (int i = 0; i < lenUsers; i++) {
            newUsers[i] = users[i];
        }
        newUsers[lenUsers] = newUser;
        users = newUsers;
        lenUsers++;

        if (newUser instanceof Driver driver) {
            addDriver(driver);
        } else if (newUser instanceof Client client) {
            addClient(client);
        }

        addUserStory(newUser);

    }

    public void addDriver(Driver newDriver){
        Driver[] newDrivers = new Driver[lenDrivers+1];
        for (int i = 0; i < lenDrivers; i++) {
            newDrivers[i] = drivers[i];
        }
        newDrivers[lenUsers] = newDriver;
        drivers = newDrivers;
        lenDrivers++;

    }

    public void addClient(Client newClient){
        Client[] newClients = new Client[lenClients+1];
        for (int i = 0; i < lenClients; i++) {
            newClients[i] = clients[i];
        }
        newClients[lenUsers] = newClient;
        clients = newClients;
        lenClients++;
    }

    public void registerRide(Client client, Driver driver, String startAdress, String endAdress){

        Ride newRide = new Ride(client, driver, startAdress, endAdress);

        addRide(newRide);

        UserStory clientStory = findOrCreateUserStory(client);
        if (clientStory != null){
            clientStory.addRide(newRide);
        }

        UserStory driverStory = findOrCreateUserStory(driver);
        if (clientStory != null){
            driverStory.addRide(newRide);
        }

    }

    public UserStory findOrCreateUserStory(User user){

        for (int i = 0; i < lenUserStories; i++){
            if (userStories[i].getUser() == user.getId()){
                return userStories[i];
            }
        }

        addUserStory(user);

        if (lenUserStories > 0) {
            return userStories[lenUserStories - 1];
        }
        return null;

    }

    public void addUserStory(User user){

        UserStory newUserStory = new UserStory(user);

        UserStory[] newUserStories = new UserStory[lenUserStories + 1];
        for (int i = 0; i < lenUserStories; i++) {
            newUserStories[i] = userStories[i];
        }
        newUserStories[lenUserStories] = newUserStory;
        userStories = newUserStories;
        lenUserStories++;

    }

    public void addRide(Ride newRide){
        Ride[] newRides = new Ride[lenRides+1];
        for (int i = 0; i < lenRides; i++) {
            newRides[i] = rides[i];
        }
        newRides[lenUsers] = newRide;
        rides = newRides;
        lenRides++;
    }

    public Ride[] getUserRides(int userId){
        for (int i = 0; i < lenUserStories; i++){
            if (userStories[i].getUser() == userId){
                int ridesCount = userStories[i].getRidesCount();
                Ride[] userRides = new Ride[ridesCount];
                for (int j = 0; j < ridesCount; j++){
                    userRides[j] = userStories[i].getRide(j);
                }
            }
        }
        return new Ride[0];
    }

    public UserStory getUserStory(int userId){
        for (int i = 0; i < lenUserStories; i++){
            if (userStories[i].getUser() == userId){
                return userStories[i];
            }
        }
        return null;
    }

    public Ride[] getUserRidesByName(String userName){
        for (int i = 0; i < lenUsers; i++){
            if (users[i].getName().equals(userName)){
                return getUserRides(users[i].getId());
            }
        }
        return new Ride[0];
    }

    public void clearUserRides(int userId) {
        UserStory userStory = getUserStory(userId);
        if (userStory != null) {
            userStory.clearRides();
            System.out.println("История поездок пользователя ID=" + userId + " очищена");
        }
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



    public void deleteUser(int deleteId){
        for (int i = 0; i < lenUsers; i++){
            if (users[i] != null && users[i].getId() == deleteId){
                if (users[i] instanceof Driver){
                    deleteDriverFromArray((Driver) users[i]);
                } else if (users[i] instanceof Client) {
                    deleteClientFromArray((Client) users[i]);
                }

                users[i] = null;
            }
        }
    }
    public void deleteDriverFromArray(Driver driver){
        for (int i = 0; i< lenDrivers; i++){
            if (drivers[i] != null && drivers[i].getId() == driver.getId()) {
                drivers[i] = null;
            }
        }
    }
    public void deleteClientFromArray(Client client){
        for (int i = 0; i< lenClients; i++){
            if (clients[i] != null && clients[i].getId() == client.getId()) {
                clients[i] = null;
            }
        }
    }

    public User[] findUsersByName(String name){
        User[] result = new User[lenUsers];
        int count = 0;
        for (int i = 0; i < lenUsers; i++){
            if (users[i] != null && users[i].getName().equals(name)){
                count++;
                if (count ==1){
                    result[count-1] = users[i];
                } else {
                    count++;
                    User[] newResult = new User[count];
                    for (int j = 0; j < result.length; j++){
                        newResult[j] = result[j];
                    }
                    newResult[count-1] = users[i];
                    result = newResult;
                }
            }
        }
        return result;
    }

    public Driver findDriversByCar(Car car){
        for (int i = 0; i < lenDrivers; i++){
            if (drivers[i] != null && drivers[i].getCar() == car){
                return drivers[i];
            }
        }
        return null;
    }

//    public Client getMostActiveClient() {
//        if (lenClients == 0) {
//            return null;
//        }
//        Client mostActiveClient = clients[0];
//        for (int i = 0; i < lenClients; i++){
//            if (clients[i].getCountRides() >= mostActiveClient.getCountRides()){
//                mostActiveClient = clients[i];
//            }
//        }
//        return mostActiveClient;
//    }
//
//    public Driver getMostActiveDriver() {
//        if (lenDrivers == 0) {
//            return null;
//        }
//        Driver mostActiveDriver = drivers[0];
//        for (int i = 0; i < lenDrivers; i++){
//            if (drivers[i].getCountRides() >= mostActiveDriver.getCountRides()){
//                mostActiveDriver = drivers[i];
//            }
//        }
//        return mostActiveDriver;
//    }













}
