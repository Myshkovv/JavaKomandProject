package Car;

public class BusinessTariff implements TarifCalculator{
    private int tariffprice;
    private String tariff;

    @Override
    public void calculateTariff(Car car){
        this.tariffprice = 200;
        this.tariff = "Business";
    }

    public int getTariffprice(){
        return this.tariffprice;
    }

    public String getTariff(){
        return this.tariff;
    }
}
