package Car;

public class TariffSelecter {
    public TarifCalculator selectTariff(Car car){
        switch (car.getName().toLowerCase()){
            case "bmw":
            case "mercedes":
            case "rolls-royce":
                return new BusinessTariff();
            case "skoda":
            case "volkswagen":
            case "lada":
            case "renault":
                return new StandardTariff();
            default:
                System.out.println("Вы не правлильно ввели марку машины, или вашей марки нет в списке допустимых марок");
                return null;
        }
    }
}
