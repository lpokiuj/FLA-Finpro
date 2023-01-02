package payment;

public class CryptoPayment extends Payment{

    public CryptoPayment(String id){
        super(id);
    }

    @Override
    public void detail(String id){
        System.out.println("Payment using Crypto with ID " + id);
    }

}
