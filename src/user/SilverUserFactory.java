package user;

public class SilverUserFactory extends UserFactory {

    @Override
    public User createUser(String type, int discount){
        return new SilverUser(type, discount);
    }

}
