package payment;

import java.util.Random;

public class TransferPaymentFactory extends PaymentFactory{

    Random rand = new Random();

    @Override
    public Payment createPayment(){
        String id = "TR";
        for(int i = 0 ; i < 3 ; i++){
            id+=rand.nextInt(10);
        }
        return new TransferPayment(id);
    }

}
