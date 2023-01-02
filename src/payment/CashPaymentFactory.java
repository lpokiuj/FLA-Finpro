package payment;

import java.util.Random;

public class CashPaymentFactory extends PaymentFactory{

    Random rand = new Random();

    @Override
    public Payment createPayment(){
        String id = "CA";
        for(int i = 0 ; i < 3 ; i++){
            id+=rand.nextInt(10);
        }
        return new CashPayment(id);
    }

}
