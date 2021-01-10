package strategypatterntshirt;

import interfaces.IPayment;

public class Cash implements IPayment {
    @Override
    public boolean pay(double amount) {
        System.out.printf("Payment of amount %s was made via cash transaction!\n", amount);
        return(true);    }
}
