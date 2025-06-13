package projects.Payphone;

import java.time.LocalTime;

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


    public double getCostperSec() {
        return PperSec;
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
        out.print("Start Time: ");
        out.printf(format(), Current);
        out.println("Phone on");

        timetaken = new Thread(() -> {
            int seconds = 0;
            try {
                while (isPhoneactive()) {
                    Thread.sleep(1000);
                    seconds++;
                    System.out.println(seconds);
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
}


