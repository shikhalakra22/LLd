package models;

public class HDFC implements Bank{
    @Override
    public boolean processPayement(double amount) {
        return false;
    }

    @Override
    public boolean processPayement(double amount, PaymentDetails details) {
        return false;
    }
}
