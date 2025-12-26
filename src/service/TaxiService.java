package service;

import MapService.Address;
import car.Car;
import ride.Ride;
import user.Client;
import user.Driver;
import user.User;
import user.UserStory;

public class TaxiService implements AddObjectService, FindObjectByIdService, DeleteObjectService, GetMostActiveObjectService, DisplayObjectService, RegisterObjectService{
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

        for (User user : users) {
            addUserStory(user);
        }
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
        newDrivers[lenDrivers] = newDriver;
        drivers = newDrivers;
        lenDrivers++;

    }

    public void addClient(Client newClient){
        Client[] newClients = new Client[lenClients+1];
        for (int i = 0; i < lenClients; i++) {
            newClients[i] = clients[i];
        }
        newClients[lenClients] = newClient;
        clients = newClients;
        lenClients++;
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
        newRides[lenRides] = newRide;
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
                return userRides;
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

    public void deleteUser(int deleteId){
        int userIndex = -1;
        for (int i = 0; i < lenUsers; i++){
            if (users[i] != null && users[i].getId() == deleteId){
                userIndex = i;
                if (users[i] instanceof Driver){
                    deleteDriverFromArray((Driver) users[i]);
                } else if (users[i] instanceof Client) {
                    deleteClientFromArray((Client) users[i]);
                }
                users[i] = null;
            }
        }
        if (userIndex == -1) {
            return;
        }
        deleteUserStory(users[deleteId]);
        for (int i = userIndex; i < lenUsers - 1; i++) {
            users[i] = users[i + 1];
        }
        users[lenUsers - 1] = null;
        lenUsers--;
    }
    public void deleteDriverFromArray(Driver driver){
        int driverIndex = -1;

        for (int i = 0; i< lenDrivers; i++){
            if (drivers[i] != null && drivers[i].getId() == driver.getId()) {
                driverIndex = i;
                drivers[i] = null;
            }
        }
        if (driverIndex == -1){
            return;
        }
        for (int i = driverIndex; i < lenDrivers - 1; i++){
            drivers[i] = drivers[i+1];
        }
        drivers[lenDrivers - 1] = null;
        lenDrivers--;
    }
    public void deleteClientFromArray(Client client){
        int clientIndex = -1;

        for (int i = 0; i< lenClients; i++){
            if (clients[i] != null && clients[i].getId() == client.getId()) {
                clientIndex = i;
                clients[i] = null;
            }
        }
        if (clientIndex == -1) {
            return;
        }
        for (int i = clientIndex; i < lenClients - 1; i++) {
            clients[i] = clients[i + 1];
        }
        clients[lenClients - 1] = null;
        lenClients--;
    }

    public void deleteUserStory(User user){
        int storyIndex = -1;

        for (int i = 0; i< lenUserStories; i++){
            if (userStories[i] != null && userStories[i].getUser() == user.getId()){
                storyIndex = i;
                userStories[i] = null;
            }
        }
        if (storyIndex == -1) {
            return;
        }
        for (int i = storyIndex; i< lenUserStories -1; i++){
            userStories[i] = userStories[i + 1];
        }
        userStories[lenUserStories - 1] = null;
        lenUserStories--;
    }

    public User[] findUsersByName(String name){
        int count = 0;
        for (int i = 0; i < lenUsers; i++) {
            if (users[i] != null && users[i].getName().equals(name)) {
                count++;
            }
        }
        User[] result = new User[count];
        int index = 0;
        for (int i = 0; i < lenUsers; i++) {
            if (users[i] != null && users[i].getName().equals(name)) {
                result[index] = users[i];
                index++;
            }
        }
        return result;
    }

    public Driver findDriversByCarNumber(String number){
        for (int i = 0; i < lenDrivers; i++){
            if (drivers[i] != null && drivers[i].getCar().getNumber().equals(number)){
                return drivers[i];
            }
        }
        return null;
    }

    public Object[] getMostActiveClient() {
        if (lenClients == 0) {
            return null;
        }

        Client mostActiveClient = clients[0];
        int maxRides = 0;

        for (int i = 0; i < lenClients; i++){
            UserStory userStory = getUserStory(clients[i].getId());
            if (userStory != null){
                int thisRides = userStory.getRidesCount();
                if (thisRides > maxRides){
                    maxRides = thisRides;
                    mostActiveClient = clients[i];
                }
            }
        }
        Object[] result = new Object[2];
        result[0] = mostActiveClient;
        result[1] = maxRides;
        return result;
    }

    public Object[] getMostActiveDriver() {
        if (lenDrivers == 0) {
            return null;
        }

        Driver mostActiveDriver = drivers[0];
        int maxRides = 0;

        for (int i = 0; i < lenDrivers; i++){
            UserStory userStory = getUserStory(drivers[i].getId());
            if (userStory != null){
                int thisRides = userStory.getRidesCount();
                if (thisRides > maxRides){
                    maxRides = thisRides;
                    mostActiveDriver = drivers[i];
                }
            }
        }

        Object[] result = new Object[2];
        result[0] = mostActiveDriver;
        result[1] = maxRides;
        return result;
    }

    public void displayUsers() {
        System.out.println("\n=== ВСЕ ПОЛЬЗОВАТЕЛИ (" + lenUsers + ") ===");
        for (int i = 0; i < lenUsers; i++) {
            System.out.println(users[i].getId() + ": " + users[i].getName()  + ": " + users[i].getPhoneNumber()  + ": " + users[i].getMail());
        }
    }

    public void displayDrivers() {
        System.out.println("\n=== ВСЕ ВОДИТЕЛИ (" + lenDrivers + ") ===");
        for (int i = 0; i < lenDrivers; i++) {
            System.out.println(drivers[i].getId() + ": " + drivers[i].getName()  + ": " + drivers[i].getPhoneNumber()  + ": " + drivers[i].getMail());
            System.out.println("   Машина : " + drivers[i].getCar().getId() + ": " +  drivers[i].getCar().getName() + ": " + drivers[i].getCar().getNumber() + ": " + drivers[i].getCar().getColor());
        }
    }

    public void displayClients() {
        System.out.println("\n=== ВСЕ КЛИЕНТЫ (" + lenClients + ") ===");
        for (int i = 0; i < lenClients; i++) {
            System.out.println(clients[i].getId() + ": " + clients[i].getName()  + ": " + clients[i].getPhoneNumber()  + ": " + clients[i].getMail());
        }
    }

    public void displayRides() {
        System.out.println("\n=== ВСЕ ПОЕЗДКИ (" + lenRides + ") ===");
        for (int i = 0; i < lenRides; i++) {
            System.out.println(rides[i].getId() + ": водитель - " + rides[i].getDriver().getName()  + ": клиент - " + rides[i].getClient().getName());
            System.out.println("   Начальная точка - " + rides[i].getStartAdress() + ": Конечная точка - " + rides[i].getEndAdress());
        }
    }

    public void displayMostActiveClient(){
        Object[] result = getMostActiveClient();
        if (result == null){
            System.out.println("Клиентов еще нет");
            return;
        }

        Client client = (Client) result[0];
        int countRides = (int) result[1];
        System.out.println("\n=== Самый активный клиент ===");
        System.out.println(client.getId() + ": " + client.getName() + ": " + "количество поездок - " + countRides);
    }

    public void displayMostActiveDriver(){
        Object[] result = getMostActiveDriver();
        if (result == null){
            System.out.println("Водителей еще нет");
            return;
        }
        Driver driver = (Driver) result[0];
        int countRides = (int) result[1];
        System.out.println("\n=== Самый активный водитель ===");
        System.out.println(driver.getId() + ": " + driver.getName() + ": " + "количество поездок - " + countRides);
    }

    public void displayUsersByName(String name){
        User[] usersByName = findUsersByName(name);
        if (usersByName.length == 0){
            System.out.println("У нас таких нет");
            return;
        }
        System.out.println("\n=== Пользователи с именем - " + name + " - " + usersByName.length);
        for (int i = 0; i < usersByName.length; i++){
            System.out.println(usersByName[i].getId() + ": " + usersByName[i].getName() + ": " + usersByName[i].getPhoneNumber() + ": " + usersByName[i].getMail());
        }
    }

    public void displayDriverByCar(String number){
        Driver driverByCar = findDriversByCarNumber(number);
        if (driverByCar == null){
            System.out.println("Машин с таким номером нет");
            return;
        }
        System.out.println("\n=== Водитель с машиной - " + number);
        System.out.println(driverByCar.getId() + ": " + driverByCar.getName() + ": " + driverByCar.getPhoneNumber() + ": " + driverByCar.getMail());
    }

    public void displayDeleteUser(int userId){
        deleteUser(userId);
        System.out.println("Удален пользователь ID= " + userId);
    }

    public void clearUserRides(int userId) {
        UserStory userStory = getUserStory(userId);
        if (userStory != null) {
            userStory.clearRides();
            System.out.println("История поездок пользователя ID=" + userId + " очищена");
        }
        else {
            System.out.println("Пользователя с таким ID не существует");
        }
    }

    public void displayUserRides(int userId){
        Ride[] userRides = getUserRides(userId);
        if (users.length == 0){
            System.out.println("Поездок нет");
            return;
        }
        System.out.println("\n=== Поездки пользователя ID= "+ userId);
        for (int i =0; i< userRides.length; i++){
            System.out.println(rides[i].getId() + ": водитель - " + rides[i].getDriver().getName()  + ": клиент - " + rides[i].getClient().getName());
            System.out.println("   Начальная точка - " + rides[i].getStartAdress() + ": Конечная точка - " + rides[i].getEndAdress());
        }
    }

    public void displayUser(int userId){
        System.out.println("\n=== Пользователь ID= " + userId);
        User user = findUserById(userId);
        if (user == null){
            System.out.println("ID не найдено");
            return;
        }
        System.out.println(user.getId() + ": " + user.getName() + ": " + user.getPhoneNumber() + ": " + user.getMail());
    }

    public void displayClient(int clientId){
        System.out.println("\n=== Клиент ID= " + clientId);
        Client client = findClientById(clientId);
        if (client == null){
            System.out.println("ID не найдено");
            return;
        }
        System.out.println(client.getId() + ": " + client.getName() + ": " + client.getPhoneNumber() + ": " + client.getMail());
    }

    public void displayDriver(int driverId){
        System.out.println("\n=== Водитель ID= " + driverId);
        Driver driver = findDriverById(driverId);
        if (driver == null){
            System.out.println("ID не найдено");
            return;
        }
        System.out.println(driver.getId() + ": " + driver.getName() + ": " + driver.getPhoneNumber() + ": " + driver.getMail());
        System.out.println("   Машина : " + driver.getCar().getId() + ": " +  driver.getCar().getName() + ": " + driver.getCar().getNumber() + ": " + driver.getCar().getColor());
    }

    public void displayRide(int rideId){
        System.out.println("\n=== Поездка ID= " + rideId);
        Ride ride = findRideById(rideId);
        if (ride == null){
            System.out.println("ID не найдено");
            return;
        }
        System.out.println(ride.getId() + ": водитель - " + ride.getDriver().getName()  + ": клиент - " + ride.getClient().getName());
        System.out.println("   Начальная точка - " + ride.getStartAdress() + ": Конечная точка - " + ride.getEndAdress());
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

    public Ride registerRide(Client client, Driver driver, String startAdress, String endAdress){
        Ride newRide = new Ride(client, driver, startAdress, endAdress);

        addRide(newRide);

        UserStory clientStory = findOrCreateUserStory(client);
        if (clientStory != null){
            clientStory.addRide(newRide);
        }

        UserStory driverStory = findOrCreateUserStory(driver);
        if (driverStory != null){
            driverStory.addRide(newRide);
        }
        return newRide;
    }


}
