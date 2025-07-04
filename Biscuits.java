package Fawry_Task;

import java.time.LocalDate;

import Fawry_Task.interfaces.ExpirableProduct;

public class Biscuits implements ExpirableProduct {

    private String name;
    private double price;
    private int quantity;
    private LocalDate expiryDate;

    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public double getPrice(){
        return this.price;
    }
    @Override
    public int getQuantity(){
        return this.quantity;
    }
    @Override
    public LocalDate getExpiryDate(){
        return this.expiryDate;
    }
    @Override
    public void setQuantity(int quantity){
        if(quantity < 0){
            throw new IllegalStateException("you can't set negative quantity ");
        }
        this.quantity=quantity;
    }
    
}
