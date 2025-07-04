package Fawry_Task;


import Fawry_Task.interfaces.ShippableProduct;

public class TV implements ShippableProduct {
        private String name;
        private double price;
        private int quantity;
        private double weight;


        public TV (String name,double price,int quantity,double weight){
            this.name = name;
            this.price=price;
            this.quantity =quantity;
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
    public void setQuantity(int quantity){
        if(quantity < 0){
            throw new IllegalStateException("you can't set negative quantity ");
        }
        this.quantity=quantity;
    }
}
