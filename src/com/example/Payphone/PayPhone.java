package com.example.Payphone;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.out;

public class PayPhone {

    private long Start;
    private long End;
    private long duration;
    private boolean Phoneactive;
    private LocalTime Current;
    private double PperSec;
    private Thread timetaken;
    private double cost;
    private ArrayList<Coin> insertedCoins = new ArrayList<Coin>();
    private String screenText;

    public PayPhone(){
        screenText = "Welcome to the PayPhone 2000\nPlease insert coin...";
    }



    public boolean isPhoneactive() {
        return Phoneactive;
    }

    public String format() {
        return "%tT\n";
    }

    public void Execute() throws InterruptedException {
        Start = System.nanoTime();
        Current = LocalTime.now();
        PperSec = 3.5;
        Phoneactive = true;

        out.println("Call started");

        timetaken = new Thread(() -> {
            int seconds = 0;
            try {
                while (isPhoneactive()) {
                    Thread.sleep(1000);
                    seconds++;


                    System.out.println("Remaining " + ((valueOfAllCoinsInserted() /PperSec) - seconds) + "seconds");
                }
            } catch (InterruptedException e) {
                System.out.println("null");
            }
        });

        timetaken.start();
    }


    public void Turnoff() {
        if (Phoneactive) {
            End = System.nanoTime();
            Current = LocalTime.now();
            Phoneactive = false;
            duration = (End - Start) / 1000000000;
            out.println("Phone off");
            out.print("Call ended after: ");
            out.printf("%s.3", duration);
            out.println(" Seconds");
            out.println("Your cost is " + cost() + " pence");
            out.print("End Time: ");
            out.printf(format(), Current);

        }
    }

    public double cost() {
        return PperSec * duration;
    }

    public String leftvalue(double input,double cost) {
        double Total = (input * 100) - cost;

        out.println(Total);

        double Poundcoin = Total / 100;
        int poundcoin = (int) Poundcoin;

        double remains = Total % 100;
        double fifty = remains / 50;
        int fiftycoin = (int) fifty;

        remains = remains % 50;
        double twenty = remains / 20;
        int twentycoin = (int) twenty;

        remains = remains % 20;
        double ten = remains / 10;
        int tencoin = (int) ten;

        remains = remains % 10;
        double five = remains / 5;
        int fivecoin = (int) five;

        remains = remains % 5;
        double two = remains / 2;
        int twocoin = (int) two;

        remains = remains % 2;
        double one = remains;
        int onecoin = (int) one;

        out.print(poundcoin + ": £1 ");
        out.print(fiftycoin + ": 50p ");
        out.print(twentycoin + ": 20p ");
        out.print(tencoin + ": 10p ");
        out.print(fivecoin + ": 5p ");
        out.print(twocoin + ": 2p ");
        out.print(onecoin + ": 1p ");
        return "";
    }

    private int valueOfAllCoinsInserted(){
        AtomicInteger total = new AtomicInteger();

        insertedCoins.forEach(e -> {
            total.addAndGet(e.value);
        });
        return total.get();
    }

    public void insertCoin(Coin coin) {
        insertedCoins.add(coin);
        setScreen(coin.label + " added\nTotal " + valueOfAllCoinsInserted());
    }

    public String getScreen() {
        return screenText;
    }
    private void setScreen(String screenText){
        this.screenText = screenText;
    }

    public void dial(String number) {
        setScreen("calling\n" + number);
        try {
            Execute();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


