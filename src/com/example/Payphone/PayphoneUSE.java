package com.example.Payphone;

import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public class PayphoneUSE {
    public static void main (String[] arg) throws InterruptedException {

        PayPhone RingRing = new PayPhone();
        Scanner key = new Scanner(in);
        out.println("Please Enter how much would you like to pay");
        out.println("£.pp");
        double amount = key.nextDouble();
        out.println("type go");
        var input = key.next();
        if (input.equals("go")) {
            RingRing.Execute();
        }

        input = key.next();
        if (input.equalsIgnoreCase("end")){
            RingRing.Turnoff();
        }
        out.println("You put in: £"+amount);
        out.println("You would get back");
    out.println(RingRing.leftvalue(amount, RingRing.cost()));
    }
}
