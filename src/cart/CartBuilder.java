package cart;

import payment.Payment;

public class CartBuilder {

    private Cart cart;

    public CartBuilder(){
        reset();
    }

    public CartBuilder setProduct(String product){
        cart.setProduct(product);
        return this;
    }

    public CartBuilder setQty(int qty){
        cart.setQty(qty);
        return this;
    }

    public CartBuilder setPrice(double price){
        cart.setPrice(price);
        return this;
    }

    public CartBuilder setPayment(Payment payment){
        cart.setPayment(payment);
        return this;
    }

    public CartBuilder setPicture(String picture){
        cart.setPicture(picture);
        return this;
    }

    public CartBuilder reset(){
        cart = new Cart();
        return this;
    }

    public Cart build(){
        return cart;
    }

}
