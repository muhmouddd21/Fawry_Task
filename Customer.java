package Fawry_Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Fawry_Task.interfaces.ExpirableProduct;
import Fawry_Task.interfaces.Product;
import Fawry_Task.interfaces.ShippableProduct;

public class Customer {
        private String name;
        private double budget;
        private ShoppingCart cart = new ShoppingCart();


        public double getBudget(){ 
            return this.budget; 
        }
        public ShoppingCart getCart(){
             return this.cart;
            }
        List<ShippableProduct> itemsToShip = new ArrayList<>();


    public Customer(String name, double budget ){
        if(name.length()<0 ){
            throw new IllegalStateException("You have to write a valid name");
        }
        this.name = name;
        this.budget =budget;
    }
    public void addToCart(Product product, int quantity){
        cart.addItem(product, quantity);
    }
    public void checkout(){

        itemsToShip.clear();

        if (cart.getItems().isEmpty()){
            throw new IllegalStateException("The cart is empty please add products");
        }


        
        for (ItemOfCart item : cart.getItems()){
            Product product = item.getProduct();
            
            if (item.getQuantity() > product.getQuantity()){
                throw new IllegalStateException("There are no products sufficient " + product.getName()+" there are only: " + product.getQuantity() + ")"
                );
            }
            
            if (product instanceof ExpirableProduct){
                ExpirableProduct expirable = (ExpirableProduct) product;

                 LocalDate expiryDate = expirable.getExpiryDate();

                if (expiryDate.isBefore(LocalDate.now())){
                    throw new IllegalStateException("Product expired: " + product.getName());
                }
            }
        }
        for (ItemOfCart item : cart.getItems()){
                Product product = item.getProduct();

                if (product instanceof ShippableProduct) {
                    itemsToShip.add((ShippableProduct) product);
                }
            }

            if (!itemsToShip.isEmpty()) {
                ShippingService shipper = new ShippingService();
                shipper.ship(itemsToShip); 
        }
            
        double subTotal = cart.calculateSubTotal();
        double shipping =30.00; // assume it is 30 for everyone 
        double totalPrice = subTotal +shipping;
        if (totalPrice > budget){
            throw new IllegalStateException("your budget is not enough for these products");
        }

        budget -= totalPrice;
        updateProducts();

        printReceipt(subTotal,shipping,totalPrice);
        
        cart.clearCart();
    }
    private void updateProducts() {
        for (ItemOfCart item : cart.getItems()) {
            Product product = item.getProduct();
            product.setQuantity(product.getQuantity() - item.getQuantity());
        }
    }
    private void printReceipt(double subtotal,double shipping,double total){
        System.out.println("\n** Shipment notice **");
        System.out.println("**"+this.name+"**");

        double totalWeight = 0;



        for (ItemOfCart item : cart.getItems()){
            Product product = item.getProduct();

            if (product instanceof ShippableProduct){
                ShippableProduct shippable = (ShippableProduct) product;

                double itemWeight = shippable.getWeight() * item.getQuantity();
                totalWeight += itemWeight;
                System.out.println(item.getQuantity() + product.getName());
            }
        }

        System.out.println("Total package weight "+ totalWeight);


       System.out.println("\n** Checkout receipt **");

        for (ItemOfCart item : cart.getItems()){
            double itemTotal = item.getQuantity() * item.getProduct().getPrice();
            System.out.println(item.getQuantity()+ " "+item.getProduct().getName()+" "+itemTotal);
        }

        System.out.println("----------------------");
        System.out.println("Subtotal "+ subtotal);
        System.out.println("Shipping " +shipping);
        System.out.println("totalPrice "+ total);

    }
    


}
