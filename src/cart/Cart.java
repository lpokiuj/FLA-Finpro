package cart;

import payment.Payment;

public class Cart {

    private String product;
    private int qty;
    private double price;
    private Payment payment;
    private String picture;

    public Cart(){}

    public Cart(String product, int qty, double price, Payment payment, String picture){
        this.product = product;
        this.qty = qty;
        this.price = price;
        this.payment = payment;
        this.picture = picture;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
