package payment;

public class CashPayment extends Payment{

    public CashPayment(String id){
        super(id);
    }

    @Override
    public void detail(String id){
        System.out.println("Payment using Cash with ID " + id);
    }
}
