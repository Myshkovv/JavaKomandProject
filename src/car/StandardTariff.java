package Car;

public class StandardTariff implements TarifCalculator{
    private int tariffprice;
    private String tariff;

    @Override
    public void calculateTariff(Car car){
        this.tariffprice = 50;
        this.tariff = "Standard";
    }

    public int getTariffprice(){
        return this.tariffprice;
    }

    public String getTariff(){
        return this.tariff;
    }
}