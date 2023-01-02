package payment;

public abstract class Payment {

    private String id;

    public Payment(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract void detail(String id);

}
