package user;

public abstract class User {

    public String type;
    public int discount;
    public User(String type, int discount){
        this.type = type;
        this.discount = discount;
    }

}
