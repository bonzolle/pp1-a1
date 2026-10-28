// Hjälpklass för del B. Läs den, men ändra den inte.
public class Card {
    private int balance;

    public Card(int balance) {
        this.balance = balance;
    }

    public void add(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}
