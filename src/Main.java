import cart.Cart;
import cart.CartBuilder;
import payment.*;
import repository.CartRepository;
import user.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in);
    CartRepository db = CartRepository.getInstance();
    UserFactory userF = null;
    User user = null;
    PaymentFactory paymentF = null;

    public void init(){
        cls();

        String type;
        while(true){
            System.out.print("Input type [Blue/Silver/Gold/Black]: ");
            type = sc.nextLine();
            if(type.equals("Blue") || type.equals("Silver") || type.equals("Gold") || type.equals("Black")){
                break;
            }
        }

        if(type.equals("Blue")){
            userF = new BlueUserFactory();
            user = userF.createUser("Blue", 0);
        }
        else if(type.equals("Silver")){
            userF = new SilverUserFactory();
            user = userF.createUser("Silver", 5);
        }
        else if(type.equals("Gold")){
            userF = new GoldUserFactory();
            user = userF.createUser("Gold", 10);
        }
        else{
            userF = new BlackUserFactory();
            user = userF.createUser("Black", 15);
        }

        menu();
    }

    public void menu(){
        int choice;

        while(true){
            cls();
            System.out.println("1. View Cart");
            System.out.println("2. New Cart");
            System.out.println("3. Exit");
            System.out.print(">> ");
            try{
                choice = sc.nextInt(); sc.nextLine();
            } catch (Exception E){
                continue;
            }

            if(choice == 1){
                getAll();
            }
            else if(choice == 2){
                store();
            }
            else if(choice == 3){
                System.out.println("Bye :)");
                return;
            }
        }
    }

    public void getAll(){
        cls();

        if(db.get().isEmpty()){
            System.out.println("No product in the cart");
            System.out.print("Press Enter to continue... ");
            sc.nextLine();
            return;
        }

        ArrayList<Cart> carts = db.get();

        int ctr = 1;
        double discount = 0;
        if(user.type.equals("Silver")){
            discount = 0.05;
        }
        else if(user.type.equals("Gold")){
            discount = 0.1;
        }
        else if(user.type.equals("Black")){
            discount = 0.15;
        }

        for (Cart cart : carts) {
            double totalPrice = cart.getPrice()*cart.getQty();
            double discountPrice = cart.getPrice()*cart.getQty()*discount;
            System.out.printf("No %d\nProduct: %s\nQuantity: %d\nPicture: %s\nTotal price: Rp. %,.0f\nDiscount: Rp. %,.0f\nGrand total: Rp. %,.0f\n", ctr++, cart.getProduct(), cart.getQty(), cart.getPicture(), totalPrice, discountPrice, totalPrice-discountPrice);

            cart.getPayment().detail(cart.getPayment().getId());
            System.out.println("");
        }

        System.out.print("Press Enter to continue... ");
        sc.nextLine();
    }

    public void store() {
        cls();

        int product, qty;
        double price;
        String productName = "", payment;
        while (true) {
            System.out.println("Product list: ");
            System.out.println("1. Betadine (Rp. 60.000)");
            System.out.println("2. Panadol Hijau (Rp. 10.000)");
            System.out.println("3. Panadol Merah (Rp. 13.000)");
            System.out.println("4. Panadol Biru (Rp. 12.000)");
            System.out.println("5. Kompres (Rp. 7.000)");
            System.out.println("6. Return");
            System.out.print(">> ");
            try {
                product = sc.nextInt();
                sc.nextLine();
            } catch (Exception E) {
                continue;
            }

            if (product >= 1 && product <= 5) {
                break;
            } else if (product == 6) {
                return;
            }
        }

        while (true) {
            System.out.print("Enter Quantity: ");
            try {
                qty = sc.nextInt();
                sc.nextLine();
            } catch (Exception E) {
                continue;
            }

            break;
        }

        while (true) {
            System.out.print("Payment Method [Cash | Transfer | Crypto]: ");
            payment = sc.nextLine();
            if (payment.equals("Cash") || payment.equals("Transfer") || payment.equals("Crypto")) {
                break;
            }
        }

        String picture = "";
        if(product == 1){
            productName = "Betadine";
            price = 60000;
            picture = "Picture of Betadine";
        }
        else if(product == 2){
            productName = "Panadol Hijau";
            price = 10000;
            picture = "Picture of Panadol Hijau";
        }
        else if(product == 3){
            productName = "Pandaol Merah";
            price = 13000;
            picture = "Picture of Panadol Merah";
        }
        else if(product == 4){
            productName = "Panadol Biru";
            price = 12000;
            picture = "Picture of Panadol Biru";
        }
        else{
            productName = "Kompres";
            price = 7000;
            picture = "Picture of Kompres";
        }

        Payment payment1 = null;
        if(payment.equals("Cash")){
            paymentF = new CashPaymentFactory();
            payment1 = paymentF.createPayment();
        }
        else if(payment.equals("Transfer")){
            paymentF = new TransferPaymentFactory();
            payment1 = paymentF.createPayment();
        }
        else {
            paymentF = new CryptoPaymentFactory();
            payment1 = paymentF.createPayment();
        }

        Cart cart = new CartBuilder().setProduct(productName).setQty(qty).setPrice(price).setPayment(payment1).setPicture(picture).build();
        db.insert(cart);

        System.out.println("Product added to cart");
        System.out.print("Press Enter to continue...");
        sc.nextLine();
    }

    public void cls(){
        for(int i = 0 ; i < 30 ; i++){
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        new Main().init();
    }
}