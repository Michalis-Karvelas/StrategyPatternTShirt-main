package strategypatterntshirt;

import interfaces.IPayment;
import models.TShirt;

public class Order {

    private TShirt tShirt;
    private IPayment payment;

    public Order() {
    }

    public Order(TShirt tShirt, IPayment payment) {
        this.tShirt = tShirt;
        this.payment = payment;
    }

    public TShirt gettShirt() {
        return tShirt;
    }

    public void settShirt(TShirt tShirt) {
        this.tShirt = tShirt;
    }

    public IPayment getPayment() {
        return payment;
    }

    public void setPayment(IPayment payment) {
        this.payment = payment;
    }

    public void makeAnOrder(TShirt tshirt, IPayment payment) {
        System.out.println(tshirt);
        double totalPrice;
        totalPrice=tshirt.getFabric().getUnitPrice()+tshirt.getFabric().getUnitPrice()*tshirt.getSize().getSizePrice()
                +tshirt.getFabric().getUnitPrice()*tshirt.getColor().getColorPrice();
        if(payment.getClass().getName().equals("strategypatterntshirt.CreditDebitCard")) {
            payment.pay(totalPrice + 5.0);
        }
        if(payment.getClass().getName().equals("strategypatterntshirt.MoneyBankTransfer")) {
            payment.pay(totalPrice + 3.0);
        }

        if(payment.getClass().getName().equals("strategypatterntshirt.Cash")) {
            payment.pay(totalPrice + 1.0);
        }

    }
}
