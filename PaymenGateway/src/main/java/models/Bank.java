package models;

public interface Bank {
    boolean processPayement(double amount);

    boolean processPayement(double amount, PaymentDetails details);
}
