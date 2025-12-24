package Car;

public class Tariff {
    private int tarifprice;
    private String tarif;

    public Tariff(String tarif, int tarifprice) {
        this.tarifprice = tarifprice;
        this.tarif = tarif;
    }

    public int getTarifprice() {
        return this.tarifprice;
    }

    public String getTarif() {
        return this.tarif;
    }
}