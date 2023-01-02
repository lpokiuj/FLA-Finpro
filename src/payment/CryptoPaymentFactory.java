package payment;

import java.util.Random;

public class CryptoPaymentFactory extends PaymentFactory{

    Random rand = new Random();

    @Override
    public Payment createPayment(){
        String id = "CR";
        for(int i = 0 ; i < 3 ; i++){
            id+=rand.nextInt(10);
        }
        return new CryptoPayment(id);
    }

}
