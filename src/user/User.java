package user;

public abstract class User {
    private String name;
    private int id;
    private String mail;
    private String phoneNumber;
    private int ridesCount = 0;
    private static int nextId = 1;
//    int[] ridesId = new int[ridesCount];

    public User(String name, String phoneNumber,String mail) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.id = nextId++;
    }

    public void newRide() {
        ridesCount++;
    }

//    public void fillRidesId(int[] ridesId, int rideId, int ridesCount){
//        for (int i = 0; i < ridesId.length; i++) {
//            ridesId[ridesCount-1] = id;
//        }
//    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public String getMail(){
        return mail;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public int getRidesCount(){
        return ridesCount;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(String mail){
        this.mail = mail;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}
