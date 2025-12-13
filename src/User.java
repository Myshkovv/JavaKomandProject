public abstract class User {
    private int id;
    private String name;
    private static int nextId = 1;

    public User(String name){
        this.name = name;
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
