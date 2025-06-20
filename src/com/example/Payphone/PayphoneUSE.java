package com.example.Payphone;

import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public class PayphoneUSE {
    public static void main (String[] arg) throws InterruptedException {
        Scanner key = new Scanner(in);

        PayPhone payPhone = new PayPhone();

        lookAtScreen(payPhone);

        boolean dial = false;

        while (!dial) {
        var input = key.next();

            if(input.equals("D")) {
                dial = true;
                payPhone.dial(key.next());
                lookAtScreen(payPhone);
            }else{
                payPhone.insertCoin(Coin.valueOfValue(Integer.parseInt(input)));
                lookAtScreen(payPhone);
            }
        }

        String input = key.next();
        if (input.equalsIgnoreCase("end")){
            payPhone.Turnoff();
        }

        key.close();
//        out.println("You put in: £"+amount);
//        out.println("You would get back");
//        out.println(payPhone.leftvalue(amount, payPhone.cost()));
    }

    private static void lookAtScreen(PayPhone payPhone) {
        out.println(payPhone.getScreen());
    }
}
