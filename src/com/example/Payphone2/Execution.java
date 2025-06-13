package com.example.Payphone2;

import java.time.LocalTime;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Execution {
    private Thread timetaken;

        public void Execute(String value) throws InterruptedException {
            Usertalk payphone = new Usertalk();
            payphone.initiation();
            Coin coin = new Coin(payphone.getTypeofcoin(),payphone.getHowmanycoins());
            payphone.setPhoneactive(true);

            out.print("*******Start Time: ");
            out.printf("%tT*******\n", java.time.LocalTime.now());
            out.println("*********Number Connected*********");

            timetaken = new Thread(() -> {
                payphone.setSeconds(0);
                try {
                    while (payphone.isPhoneactive()) {
                        Thread.sleep(1000);
                        payphone.setSeconds(payphone.getSeconds()+1);
                        System.out.println(payphone.getSeconds());

                        if (payphone.getSeconds() >= coin.talktime(coin.getPps(),coin.inputcoin
                                (coin.getTypecoin(),coin.getAmountcoin()))) {
                            out.println("********Call time reached.********");
                            out.println();
                            payphone.setPhoneactive(false);
                            payphone.endpoint(payphone.getTypeofcoin(), payphone.getHowmanycoins());
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("Error");
                }
            });
            timetaken.start();

            Thread abortcall = new Thread(()-> {
                Scanner key = new Scanner(in);
                var choice = key.next();
                if (choice.equalsIgnoreCase(value)) {
                    payphone.setPhoneactive(false);
                    out.println("********Call Manually ended********");
                    out.println();
                    payphone.endpoint(payphone.getTypeofcoin(), payphone.getHowmanycoins());
                }
            });
            abortcall.start();
        }
    }

