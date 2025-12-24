//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Здесь пример, как создавать адреса");
        ArrayOfAddress addressBook = new ArrayOfAddress();
        MakeAddress addressMaker = new MakeAddress(addressBook);
        System.out.println("Создание адреса");
        Address someAddress = addressMaker.createAddress("Толстого 14", "Казань");
        System.out.println(someAddress);
    }
}