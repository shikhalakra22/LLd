package models;

public interface Payment {
    boolean pay(double amount, PaymentDetails details);
}
