package car;

import java.util.Random;

public class Car {

    Random random = new Random();

    private String[] marka = {"Mercedes", "BMW", "Volkswagen", "Lada", "Renault", "Skoda", "Rolls-Royce"};
    private String name;
    private String number;
    private String color;
    private static int nextid = 1;
    private int id;
    private String tarif;

    public Car(String name, String number, String color){
        setName(name);
        setNumber(number);
        setColor(color);
        rating(name);
        this.id = nextid;
        nextid++;
    }

    public void rating(String name){
        for(int i = 0; i<7; i++){
            if (marka[i].equals(name)){
                if (name.equals(marka[0]) || name.equals(marka[1]) || name.equals(marka[6])){
                    this.tarif = "Premium";
                }
                else{
                    this.tarif = "Standard";
                }
            }
        }
        if (this.tarif == null){
            System.out.println("Убедитесь в правильности написания марки машины. Вашей марки машины нет в списке доступных марок");
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public void setColor(String color){
        this.color = color;
    }

    public int getId() {
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getNumber(){
        return this.number;
    }

    public String getColor(){
        return this.color;
    }

    public String getTarif(){
        return this.tarif;
    }
}
