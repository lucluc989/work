package com.example.Payphone;

import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public class PayphoneUSE {
    public static void main (String[] arg) throws InterruptedException {

        PayPhone payPhone = new PayPhone();
        out.println(payPhone.getScreen());


        payPhone.insertCoin(Coin.FIFTYPENCE);


        Scanner key = new Scanner(in);

        out.println("Please Enter how much would you like to pay");
        out.println("£.pp");
        double amount = key.nextDouble();

        boolean dial = false;

        while (!dial) {
            if(key.next().equals("D")) {
                dial = true;
                payPhone
            }else{
                Coin.valueOfValue(key.nextInt());
            }
        }



        input = key.next();
        if (input.equalsIgnoreCase("end")){
            payPhone.Turnoff();
        }
        out.println("You put in: £"+amount);
        out.println("You would get back");
        out.println(payPhone.leftvalue(amount, payPhone.cost()));
    }
}
