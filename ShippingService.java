package Fawry_Task;

import java.util.List;

import Fawry_Task.interfaces.ShippableProduct;

    public class ShippingService{

    public void ship(List<ShippableProduct> items) {
            System.out.println("** Shipment notice **");
            double totalWeight = 0;

            for (ShippableProduct item : items) {
                System.out.printf("- %s (%.2f kg)%n", item.getName(), item.getWeight());
                totalWeight += item.getWeight();
            }

            System.out.printf("Total weight: %.2f kg%n", totalWeight);
    }
}

