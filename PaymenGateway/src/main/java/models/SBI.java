package models;

public class SBI implements Bank{
    @Override
    public boolean processPayement(double amount) {
        return false;
    }
    @Override
    public boolean processPayement(double amount, PaymentDetails details) {
        return false;
    }
}
