package user;

import car.Car;

public class Driver extends User {
    private Car car;
    private double points;
    private boolean isAvailable;

    public Driver(String name, String phoneNumber, String mail, Car car) {
        super(name,phoneNumber, mail);
        this.car = car;
    }

    public boolean getIsAvailable(){
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public void addPoints(double points){
        this.points += points;
    }

    public double getPoints(){
        return points;
    }

    public Car getCar(){
        return car;
    }

    public void setCar(Car car){
        this.car = car;
    }

    public String getTarif(){
        TariffCalculate calculate = new TariffCalculate();
        Tariff tariff = calculate.calculateTariff(car);
        return tariff.getTarif();
    }

    public String getTarifPrice(){
        TariffCalculate calculate = new TariffCalculate();
        Tariff tariff = calculate.calculateTariff(car);
        return tariff.getTarifPrice();
    }
}
