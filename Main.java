package Fawry_Task;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
    
        // Creating products
        Cheese cheese = new Cheese("feta cheese", 13, 5, LocalDate.of(2025, 10, 15), 1.5);

        TV tv = new TV("LG ", 1000, 3, 18.5);
    
        MobileScratchCards scratchCard = new MobileScratchCards("50LE Mobile cards", 45.00, 10);

        // Creating a customer
        Customer customer = new Customer("Mahmoud abdelhaleem ahmed", 2000.00);
        
        System.out.println("=== INITIAL STATE ===");
        System.out.println("Product available");
        System.out.println("Cheese : " + cheese.getQuantity());
        System.out.println("TVs : " + tv.getQuantity() );
        System.out.println("Scratch Cards : " + scratchCard.getQuantity());
        System.out.println("==========================\n");
        
        // Test 1: Normal case
        System.out.println("TEST 1: normal case");
        try {
            customer.addToCart(cheese, 2);
            customer.addToCart(tv, 1);
            customer.addToCart(scratchCard, 1);
            
            customer.checkout();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Test 2: Insufficient quantity
        System.out.println("\ntest 2: Insufficient quantity");
        try {
            customer.addToCart(tv, 3);  // last case 2 and there was 3 so this is not enough
            customer.checkout();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            customer.getCart().clearCart();;  
        }
        
        // Test 3: expired product
        System.out.println("\ntest 3: Expired product");
        try {
            Cheese expiredCheese = new Cheese("old cheese", 9.99, 3,LocalDate.of(2020, 1, 1), 0.5);
            customer.addToCart(expiredCheese, 1);
            customer.checkout();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            customer.getCart().clearCart();
        }
        
        // Test 4: there is no enough moneyy
        System.out.println("\ntest 4: no enough money");
        try {
            customer.addToCart(tv, 2);  // 2 TVs = 2000 LE and the budget from the first case is 1000
            customer.checkout();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            customer.getCart().clearCart();
        }
        
        // test 5: empty cart
        System.out.println("\ntest 5: empty cart");
        try {
            customer.checkout();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // final state after all of these operations
        System.out.println("\n=== final state after all of these operations ===");
        System.out.println("Customer Balance: $" + customer.getBudget());
        System.out.println("Product available :");
        System.out.println("Cheese : " + cheese.getQuantity() );
        System.out.println("TVs : " + tv.getQuantity());
        System.out.println("Scratch Cards : " + scratchCard.getQuantity());
    }
    
    
}
