package user;

public class GoldUserFactory extends UserFactory {

    @Override
    public User createUser(String type, int discount){
        return new GoldUser(type, discount);
    }

}
