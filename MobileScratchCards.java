package Fawry_Task;

import Fawry_Task.interfaces.UnshippableProduct;

public class MobileScratchCards implements UnshippableProduct {

    private String name;
    private double price;
    private int quantity;

    public MobileScratchCards(String name, double price, int quantity){
        this.name = name;
        this.price =price;
        this.quantity =quantity;
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public double getPrice() {
        return this.price;
    }
    @Override
    public int getQuantity() {
        return this.quantity;
    }
    @Override
    public void setQuantity(int quantity){
        if(quantity < 0){
            throw new IllegalStateException("you can't set negative quantity ");
        }
        this.quantity=quantity;
    }
    
}
