package models;

public class NetBanking implements Payment{
    private Bank bank;
    public NetBanking(Bank bank){
        this.bank=bank;
    }
    @Override
    public boolean pay(double amount, PaymentDetails details) {
        return false;
    }
}
