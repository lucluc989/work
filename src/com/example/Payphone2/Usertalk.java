package com.example.Payphone2;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.*;

public class Usertalk {

    private boolean Phoneactive;
    private String CalledNumber;
    private int typeofcoin;
    private int howmanycoins;
    private int seconds;

    public int getSeconds() {
        return seconds;
    }
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
    public String getCalledNumber() {
        return CalledNumber;
    }
    public boolean isPhoneactive() {
        return Phoneactive;
    }
    public void setPhoneactive(boolean phoneactive) {
        Phoneactive = phoneactive;
    }

    public void initiation() {
        Coin info = new Coin(1, 1);
        Scanner key = new Scanner(in);
        do {
            out.println("****************************************");

            out.println("*******Welcome to Luc's Payphone********");
            out.println("****************************************");
            out.println("****Current Charge is " + info.getPps() + "p per second*****");
            out.println("**Only one coin type for input at once**");
            out.println();
            out.println("*************continue?(y/n)*************");
            String answer = key.next();
            if (answer.equalsIgnoreCase("y")) {
                boolean notvalidvalue = false;
                do {
                    try {
                        out.println("****************************************");
                        out.println("Please input what coins you are using today");
                        out.println("********Types of accepted coins*********");
                        System.out.println("** 1p **   ** 2p **   ** 5p **");
                        System.out.println("** 10p **  ** 20p **  ** 50p **");
                        System.out.println("           ** £1(100) **          ");
                        out.println("****************************************");

                        typeofcoin = key.nextInt();
                        if (typeofcoin == 1 || typeofcoin == 2 || typeofcoin == 5 || typeofcoin == 10 ||
                                typeofcoin == 20 || typeofcoin == 50 || typeofcoin == 100) {
                            notvalidvalue = true;
                        } else {
                            out.println("This is not a coin type, please try again.");
                        }
                    } catch (
                            InputMismatchException e) { // not sure on execeptions yet really but when i google they say they fix like everything so...
                        out.println("This is not a coin type, please try again.");
                        key.next();
                    }
                } while (!notvalidvalue) ;


                while (true) {
                    out.println("****************************************");
                    out.println("How many coins would you like to enter");
                    out.println("****************************************");
                    if (key.hasNext()) {
                        howmanycoins = key.nextInt();
                        break;
                    } else {
                        out.println("You need to add a number of coins here, please try again.");
                        key.next();
                    }
                }

                Coin vals = new Coin(typeofcoin, howmanycoins);
                out.println("You will have " + (vals.talktime(vals.getPps(), vals.inputcoin(vals.getTypecoin(), vals.getAmountcoin()))) + " Seconds talk time.");
                out.println();
                out.println("****************************************");
                out.println("Dial the number you want to call");
                out.println("****************************************");
                CalledNumber = key.next();
                Phoneactive = true;
                out.println("*************Connecting...**************");
                out.println("****press"+" E"+" to exit at any time****"); //can I add this to be what ever the parameter string is set to?
                for (int i=0;i<3;i++) {
                    out.println("         ****Connecting****");
                    try {
                        Thread.sleep(1000 * (i + 1));
                    } catch (InterruptedException e) {
                        out.println("Connection Interuption Error");
                    }

                }
                break;
            }
            else if (answer.equalsIgnoreCase("n")) {
                out.println("Suit yourself..");
                System.exit(0);
            } else{
                out.println("Invalid input. Please type 'y' or 'n'.");
            }
        } while(true);
    }
    public int getTypeofcoin() {
        return typeofcoin;
    }
    public int getHowmanycoins() {
        return howmanycoins;
    }
    public void endpoint(int Typeofcoin, int Towmanycoins) {
        Coin coin = new Coin(Typeofcoin, Towmanycoins);
        out.println("***********************************");
        out.println("Call lasted: "+ seconds+" seconds to - "+getCalledNumber());

        if (coin.talktime(coin.getPps(), coin.inputcoin(coin.getTypecoin(), coin.getAmountcoin())) - seconds >= 1) {
            System.out.println("You had "+ (coin.talktime(coin.getPps(), coin.inputcoin(coin.getTypecoin(), coin.getAmountcoin()))-seconds) + " Seconds left before auto-termination");
        } else {
            out.println("No value in machine left");
        }

        out.println("***********************************");
        out.println(coin.leftcoin(coin.inputcoin(coin.getTypecoin(),coin.getAmountcoin()),coin.getPps(),seconds));
    }
}
