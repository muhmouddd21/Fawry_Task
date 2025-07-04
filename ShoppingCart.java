package Fawry_Task;

import java.util.ArrayList;
import java.util.List;

import Fawry_Task.interfaces.Product;


public class ShoppingCart {
    private List<ItemOfCart> items = new ArrayList<>();

    public ShoppingCart(){

    }
    public void addItem(Product product,int quantity){
        if(quantity <0){
            throw new IllegalStateException("You have to add positive quantity");
        }
        if(quantity > product.getQuantity()){
            throw new IllegalStateException("This item doesn't exist now");
        }
        items.add(new ItemOfCart(product, quantity));  
    }

     public double calculateSubTotal(){
        return items.stream()
            .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
            .sum();
    }
    public List<ItemOfCart> getItems(){
        return new ArrayList<>(items); 
    }
    public void clearCart(){
        this.items.clear();
    }


}
