package Fawry_Task.interfaces;

import java.time.LocalDate;

public interface ExpirableProduct extends Product {
    LocalDate getExpiryDate();
} 