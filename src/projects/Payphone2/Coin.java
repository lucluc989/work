package projects.Payphone2;

    public class Coin {
        private int typecoin;
        private int amountcoin;
        private int pps = 5;

        public Coin(int Typecoin, int Amountcoin){ //constructor
            typecoin = Typecoin;
            amountcoin = Amountcoin;
        }

        public int getPps() {
            return pps;
        }

        public void setPps(int pps) {
            this.pps = pps;
        }

        public int getTypecoin() {
            return typecoin;
        }

        public void setTypecoin(int typecoin) {
            this.typecoin = typecoin;
        }

        public int getAmountcoin() {
            return amountcoin;
        }

        public void setAmountcoin(int amountcoin) {
            this.amountcoin = amountcoin;
        }

    public int inputcoin (int type, int amount) { //call to calc value at start
        return type * amount;
    }

    public int talktime (int pencepersec,int inputcoin) { //call to show how many seconds user has to talk
        return inputcoin/pencepersec;
    }

    public String leftcoin (int coininput,int pencepersec,int calltime) { //how many coins left over after call
        int leftcoin = coininput -(pencepersec*calltime);
        var coinback = 0;
                switch (typecoin){ //Currently to work on. think i can play around with continue; and make it so IF coin back =0 you continue.
                    case 1: // it still appears where the user has ran out of time too so i need to fix that as you'll never need info from left coin when time runs out.
                        coinback = leftcoin;
                        System.out.println("You will receive"+coinback+" 1p coins back");
                        break;
                    case 2:
                        coinback = leftcoin/2;
                        System.out.println("You will receive"+coinback+" 2p coins back");
                        break;
                    case 5:
                        coinback = leftcoin/5;
                        System.out.println("You will receive "+coinback+" 5p coins back");
                        break;
                    case 10:
                        coinback = leftcoin/10;
                        System.out.println("You will receive "+coinback+" 10p coins back");
                        break;
                    case 20:
                        coinback = leftcoin/20;
                        System.out.println("You will receive "+coinback+" 20p coins back");
                        break;
                    case 50:
                        coinback = leftcoin/50;
                        System.out.println("You will receive "+coinback+" 50p coins back");
                        break;
                    case 100:
                        coinback = leftcoin/100;
                        System.out.println("You will receive "+coinback+" £1 coins back");
                        break;
                    default:
                        System.out.println("You've entered a value that wasn't a coin!");
                        break;
                }
        return "";
    }
}
