package user;

public class BlackUserFactory extends UserFactory {

    @Override
    public User createUser(String type, int discount){
        return new BlackUser(type, discount);
    }

}
