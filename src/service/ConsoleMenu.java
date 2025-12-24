package service;

import car.Car;
import ride.Ride;
import user.Client;
import user.Driver;

import java.util.Scanner;

public class ConsoleMenu implements RegisterObjectInConsoleService{
    private TaxiService taxiService;
    private Scanner scanner;

    public ConsoleMenu(TaxiService taxiService){
        this.taxiService = taxiService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean working = true;

        while (working){
            printMainMenu();
            int input = readIntScanner("Выберите действие: ");

            switch (input) {
                case 1 -> register();
                case 2 -> statistic();
                case 3 -> find();
                case 4 -> delete();
                case 0 -> {
                    working = false;
                    System.out.println("Выход из программы. До встречи :)");
                }
                default -> System.out.println("Неверный выбор");

            }
        }
    }

    private int readIntScanner(String string){
        System.out.println(string);

        while (!scanner.hasNextInt()){
            scanner.next();
            System.out.println("Ошибка! Введите целое число");
            System.out.print(string);
        }
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    public void printMainMenu(){
        System.out.println("\n======= ТАКСИ СЕРВИС =======");
        System.out.println("1 - Зарегестрировать");
        System.out.println("2 - Показать статистику");
        System.out.println("3 - Поиск");
        System.out.println("4 - Удаление");
        System.out.println("0 - Выход");
        System.out.println("==============================");

    }

    public void register() {
        boolean working = true;

        while (working) {
            System.out.println("\n=== РЕГИСТРАЦИЯ ===");
            System.out.println("1 - Зарегестрировать нового клиента");
            System.out.println("2 - Зарегестрировать нового водителя");
            System.out.println("3 - Зарегестрировать новую поездку");
            System.out.println("0 - назад");

            int input = readIntScanner("Выберите действие");

            switch (input){
                case 1 -> registerClient();
                case 2 -> registerDriver();
                case 3 -> registerRide();
                case 0 -> working = false;
                default -> System.out.println("Неверный выбор");
            }
        }
    }

    public void registerClient(){
        System.out.println("\n=== РЕГИСТРАЦИЯ КЛИЕНТА ===");
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите номер телефона: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Введите email: ");
        String mail = scanner.nextLine();

        Client client = taxiService.registerClient(name, phoneNumber, mail);
        System.out.println("----------------------------");
        System.out.println("Клиент успешно зарегистрирован! ID= " + client.getId());
        System.out.println("----------------------------");
    }
    public void registerDriver(){
        System.out.println("\n=== РЕГИСТРАЦИЯ ВОДИТЕЛЯ ===");
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите номер телефона: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Введите email: ");
        String mail = scanner.nextLine();

        System.out.println("\n=== Информация о машине ===");
        System.out.print("Марка машины: ");
        String carName = scanner.nextLine();
        System.out.print("Номер машины: ");
        String carNumber = scanner.nextLine();
        System.out.print("Цвет машины: ");
        String carColor = scanner.nextLine();
        Car car = new Car(carName, carNumber, carColor);

        Driver driver = taxiService.registerDriver(name, phoneNumber, mail, car);
        System.out.println("----------------------------");
        System.out.println("Водитель успешно зарегистрирован! ID= " + driver.getId());
        System.out.println("----------------------------");
    }
    public void registerRide(){
        System.out.println("\n=== РЕГИСТРАЦИЯ ПОЕЗДКИ ===");
        taxiService.displayDrivers();
        int driverID = readIntScanner("Введите ID водителя: ");
        taxiService.displayClients();
        int clientID = readIntScanner("Введите ID клиента: ");

        Driver driver = taxiService.findDriverById(driverID);
        Client client = taxiService.findClientById(clientID);

        System.out.print("Адрес отправления: ");
        String startAddress = scanner.nextLine();

        System.out.print("Адрес назначения: ");
        String endAddress = scanner.nextLine();

        Ride ride = taxiService.registerRide(client, driver, startAddress, endAddress);
        System.out.println("----------------------------");
        System.out.println("Поездка успешно зарегистрирована! ID= " + ride.getId());
        System.out.println("----------------------------");
    }

    public void statistic() {
        boolean working = true;

        while (working) {
            System.out.println("\n=== СТАТИСТИКА ===");
            System.out.println("1 - Все пользователи");
            System.out.println("2 - Все клиенты");
            System.out.println("3 - Все водители");
            System.out.println("4 - Все поездки");
            System.out.println("5 - Самый активный водитель");
            System.out.println("6 - Самый активный клиент");
            System.out.println("0 - назад");

            int input = readIntScanner("Выберите действие");

            switch (input){
                case 1 -> taxiService.displayUsers();
                case 2 -> taxiService.displayClients();
                case 3 -> taxiService.displayDrivers();
                case 4 -> taxiService.displayRides();
                case 5 -> taxiService.displayMostActiveDriver();
                case 6 -> taxiService.displayMostActiveClient();
                case 0 -> working = false;
                default -> System.out.println("Неверный выбор");
            }
        }
    }

    public void find() {
        boolean working = true;

        while (working) {
            System.out.println("\n=== ПОИСК ===");
            System.out.println("1 - Найти пользователя по ID");
            System.out.println("2 - Найти клиента по ID");
            System.out.println("3 - Найти водителя по ID");
            System.out.println("4 - Найти поездку по ID");
            System.out.println("5 - Найти пользователей по имени");
            System.out.println("6 - Найти водителя по номеру машины");
            System.out.println("7 - Найти поездки пользователя по ID");
            System.out.println("0 - назад");

            int input = readIntScanner("Выберите действие");

            switch (input){
                case 1 ->{
                    int id = readIntScanner("Введите ID пользователя :");
                    taxiService.displayUser(id);
                }
                case 2 ->{
                    int id = readIntScanner("Введите ID клиента :");
                    taxiService.displayClient(id);
                }
                case 3 ->{
                    int id = readIntScanner("Введите ID водителя :");
                    taxiService.displayDriver(id);
                }
                case 4 ->{
                    int id = readIntScanner("Введите ID поездки :");
                    taxiService.displayRide(id);
                }
                case 5 ->{
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    taxiService.displayUsersByName(name);
                }
                case 6 ->{
                    System.out.println("Введите номер машины: ");
                    String number = scanner.nextLine();
                    taxiService.displayDriverByCar(number);
                }
                case 7 ->{
                    int id = readIntScanner("Введите ID пользователя: ");
                    taxiService.displayUserRides(id);
                }
                case 0 -> working = false;
                default -> System.out.println("Неверный выбор");
            }
        }
    }

    public void delete() {
        boolean working = true;

        while (working) {
            System.out.println("\n=== УДАЛЕНИЕ ===");
            System.out.println("1 - Удалить пользователя");
            System.out.println("2 - Очистить историю поездок пользователя");
            System.out.println("0 - назад");

            int input = readIntScanner("Выберите действие");

            switch (input) {
                case 1 -> {
                    int id = readIntScanner("Введите ID пользователя для удаления: ");
                    taxiService.displayDeleteUser(id);
                }
                case 2 -> {
                    int id = readIntScanner("Введите ID пользователя для очистки истории: ");
                    taxiService.clearUserRides(id);
                }
                case 0 -> working = false;
                default -> System.out.println("Неверный выбор");
            }
        }
    }

}
