package user;

public class BlueUserFactory extends UserFactory {

    @Override
    public User createUser(String type, int discount){
        return new BlueUser(type, discount);
    }

}
