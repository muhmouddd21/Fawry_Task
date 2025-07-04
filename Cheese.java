package Fawry_Task;

import java.time.LocalDate;

import Fawry_Task.interfaces.ExpirableProduct;
import Fawry_Task.interfaces.ShippableProduct;
public class Cheese implements ExpirableProduct,ShippableProduct {
        private String name;
        private double price;
        private int quantity;
        private LocalDate expiryDate;
        private double weight;


        public Cheese(String name,double price,int quantity,LocalDate expiryDate,double weight){
            this.name =name;
            this.price =price;
            this.quantity =quantity;
            this.expiryDate =expiryDate;
            this.weight=weight;
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
    public double getWeight() {
        return this.weight;
    }
    @Override
    public LocalDate getExpiryDate() {
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
