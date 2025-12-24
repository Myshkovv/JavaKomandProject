package Car;

public class Car {
    private String name;
    private String number;
    private String color;
    private static int nextid = 1;
    private int id;

    public Car(String name, String number, String color){
        this.name = name;
        this.number = number;
        this.color = color;
        this.id = nextid;
        nextid++;
    }

    public int getId() {
        return this.id;
    }

    public String getName(){
        return this.name.toLowerCase();
    }

    public String getNumber(){
        return this.number.toUpperCase();
    }

    public String getColor(){
        return this.color.toLowerCase();
    }

}
