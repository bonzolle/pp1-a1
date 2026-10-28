void main() {
    Card a = new Card(50);
    Card b = new Card(50);
    Card c = a;

    IO.println(a == b);
    IO.println(a == c);
    IO.println(a.getBalance() == b.getBalance());
}
