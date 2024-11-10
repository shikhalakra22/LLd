package models;

import enums.Modes;

import java.util.Map;

public class PaymentFactory {
    private final Map<String, Bank> bankRouters;

    public PaymentFactory(Map<String, Bank> bankRouters) {
        this.bankRouters = bankRouters;
    }

    public Payment createPayment(Modes mode, String bankname){
        Bank bank = bankRouters.getOrDefault(bankname, new HDFC());
        switch (mode){
            case UPI:
                return new UPI(bank);
            case CREDITCARD:
                return new CreditCard(bank);
            case NETBANKING:
                return new NetBanking(bank);
            default:
                throw new IllegalArgumentException("Unsupported payment type");
        }

    }
}
