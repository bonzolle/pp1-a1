public class TravelCard {
    private int number;
    private int balance;
    private int tripCount;
    private Trip lastTrip;
    private static final int MAX_BALANCE = 200;
    private static int cardCount;
    private static int cardNumber = 1001;

    public TravelCard() {
        this.number = cardNumber;
        this.balance = 0;
        this.tripCount = 0;
        this.lastTrip = null;
        cardCount = cardCount + 1;
        cardNumber = cardNumber + 1;
    }

    //resan
    public boolean travel(Trip trip){

        if (trip == null || !pay(trip.getPrice())) {
            return false;
        }
        tripCount += 1;
        lastTrip = trip;
        return true;
    }
    public static int getIssuedCount(){
        return cardCount;
    }
    public int getNumber() {
        return number;
    }

    public int getBalance() {
        return balance;
    }

    public int getTripCount(){
        return tripCount;
    }

    public Trip getLastTrip(){

        return lastTrip;
    }

    public boolean topUp(int amount) {
        if (balance + amount > MAX_BALANCE || amount <= 0){
            return false;
        }
        else {
            balance += amount;
            return true;
        }
    }

    public boolean pay(int amount) {

        if (amount <= 0 || amount > balance){
            return false;
        }
        else {
            balance -= amount;
            return true;
        }

    }
    @Override
    public String toString() {
        return " card " + number + ": Saldo (" + balance + ") euro, " + getTripCount() + " Trips," + " Last trip: " + lastTrip;
    }
}
