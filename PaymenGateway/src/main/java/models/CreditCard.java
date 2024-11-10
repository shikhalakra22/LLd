package models;

public class CreditCard implements Payment{
    private Bank bank;
    public CreditCard(Bank bank){
        this.bank=bank;
    }

    @Override
    public boolean pay(double amount, PaymentDetails details) {
        return false;
    }
}
