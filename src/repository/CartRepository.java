package repository;

import cart.Cart;

import java.util.ArrayList;

public class CartRepository {
    private static CartRepository instance = null;
    private ArrayList<Cart> carts;

    private CartRepository(){
        this.carts = new ArrayList<Cart>();
    }

    public void insert(Cart data){
        this.carts.add(data);
    }

    public ArrayList<Cart> get(){
        return carts;
    }

    public static CartRepository getInstance(){
        if (instance == null) {
            instance = new CartRepository();
        }
        return instance;
    }

}
