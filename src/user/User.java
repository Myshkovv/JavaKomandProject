package user;

public abstract class User {
    private String name;
    private String mail;
    private String phoneNumber;
    private final int id;
    private static int nextId = 1;

    public User(String name, String phoneNumber,String mail) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.id = nextId++;
    }

    public String getName(){
        return name;
    }

    public String getMail(){
        return mail;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMail(String mail){
        this.mail = mail;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}
