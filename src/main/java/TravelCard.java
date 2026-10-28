public class TravelCard {
    private int number;
    private int balance;

    public TravelCard(int number, int balance) {
        this.number = number;
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public int getBalance() {
        return balance;
    }
    @Override
    public String toString() {
        return "card " + number + " (" + balance + ")";
    }
}
