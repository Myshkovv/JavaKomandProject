package car;

public class TariffCalculate implements TarifCalculator{
    @Override
    public Tariff calculateTariff(Car car){
        if (car.getName().equals("bmw") || car.getName().equals("mercedes") || car.getName().equals("rolls-royce")) {
            return new Tariff("Business", 200);
        }
        else if (car.getName().equals("skoda") || car.getName().equals("volkswagen") || car.getName().equals("lada") || car.getName().equals("renault")){
            return new Tariff("Standard", 50);
        }
        else{
            System.out.println("Вы не правлильно ввели марку машины, или вашей марки нет в списке допустимых марок");
            return null;
        }
    }
}
