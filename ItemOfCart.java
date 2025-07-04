package Fawry_Task;

import Fawry_Task.interfaces.Product;

public class ItemOfCart {
    private Product product;
    private int quantity;

    public ItemOfCart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct(){
        return this.product;
    }
    public int getQuantity(){
        return this.quantity;
    }
}
