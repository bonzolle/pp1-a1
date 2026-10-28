public class TravelCard {
    private int number;
    private int balance;
    private static final int MAX_BALANCE = 200;

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

    public void topUp(int amount) {
        balance += amount;
    }

    public void pay(int amount) {
        balance -= amount;
    }
    @Override
    public String toString() {
        return "card " + number + " (" + balance + ")";
    }
}
