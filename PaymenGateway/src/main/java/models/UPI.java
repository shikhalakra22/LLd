package models;

public class UPI implements Payment{
    private Bank bank;
    public UPI(Bank bank){
        this.bank=bank;
    }
    @Override
    public boolean pay(double amount, PaymentDetails details) {
      return bank.processPayement(amount,details);
    }
}
