package strategypatterntshirt;

import interfaces.IPayment;

public class MoneyBankTransfer implements IPayment {

    @Override
    public boolean pay(double amount) {
        System.out.printf("Payment of amount %s was made via Money / Bank Transfer transaction!\n", amount);
        return(true);
    }
    
}
