package user;

public abstract class UserFactory {
    public abstract User createUser(String type, int discount);
}
