public class TravelCard {
    private int number;
    private int balance;
    private static final int MAX_BALANCE = 200;
    private static int cardCount;
    private static int cardNumber = 1001;

    public TravelCard() {
        this.number = cardNumber;
        this.balance = 0;
        cardCount = cardCount + 1;
        cardNumber = cardNumber + 1;
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

    public boolean topUp(int amount) {
        if (balance + amount >= MAX_BALANCE){
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
        return "card " + number + " (" + balance + ")";
    }
}
