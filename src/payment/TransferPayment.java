package payment;

public class TransferPayment extends Payment{

    public TransferPayment(String id){
        super(id);
    }

    @Override
    public void detail(String id){
        System.out.println("Payment using Transfer with ID " + id);
    }
}
