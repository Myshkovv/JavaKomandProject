package car;

public class Tariff {
    private int tarifprice;
    private String tarif;

    public Tariff(String tarif, int tarifprice) {
        this.tarifprice = tarifprice;
        this.tarif = tarif;
    }

    public int getTarifPrice() {
        return this.tarifprice;
    }

    public String getTarif() {
        return this.tarif;
    }
}