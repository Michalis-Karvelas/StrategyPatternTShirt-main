package strategypatterntshirt;

import interfaces.IPayment;
import models.*;

import java.util.Scanner;

public class StrategyPatternTShirt {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to T-shirt Creation And Price Calculation Program");
        System.out.println("Please give the base name of the T-shirts that are going to be produced");
        System.out.println("---------------------------------------------------------------------------------------");
        String name=sc.nextLine();
        System.out.println("If you want to check 4 random t-shirts press 1");
        System.out.println("If you want to see all of the 343 possible combinations of Fabric-Size-Color press 2");
        System.out.println("---------------------------------------------------------------------------------------");
        String choice=sc.nextLine();
        int n=1; //variable for the right naming of the t-shirts
        String newName;
        StrategyPatternTShirt myMainClass = new StrategyPatternTShirt();
        IPayment payment;
        while (!choice.equals("1")&&!choice.equals("2")){
            System.out.println("You inserted an invalid number, please insert 1 or 2");
            System.out.println("---------------------------------------------------------------------------------------");
            choice=sc.nextLine();
        }
        if(choice.equals("1")){
            for( int i=0; i<4;i++) {
                RandomTShirt TShirt = new RandomTShirt(name+(1+i));
                // Payment By Cash
                payment = new Cash();
                myMainClass.makeAnOrder(TShirt, payment);
                // Payment By MoneyBankTransfer
                payment = new MoneyBankTransfer();
                myMainClass.makeAnOrder(TShirt, payment);
                // Payment By CreditDebitCard
                payment = new CreditDebitCard();
                myMainClass.makeAnOrder(TShirt, payment);
                System.out.println("---------------------------------------------------------------------------------------");
            }
        }
        else {
            for (Fabric fabric : Fabric.values()) {
                //set fabric values
                for (Size size : Size.values()) {
                    //set size values
                    for (Color color : Color.values()) {
                        //set color values,right name and create a t-shirt
                        newName = name + n;
                        TShirt tshirt = new TShirt(newName, color, size, fabric);//name+1+i
                        n = n + 1;
                        payment = new Cash();
                        myMainClass.makeAnOrder(tshirt, payment);
                        payment = new MoneyBankTransfer();
                        myMainClass.makeAnOrder(tshirt, payment);
                        payment = new CreditDebitCard();
                        myMainClass.makeAnOrder(tshirt, payment);
                        System.out.println("---------------------------------------------------------------------------------------");
                    }
                }
            }
        }
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
