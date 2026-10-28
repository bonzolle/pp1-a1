void fill(Card c) {
    c.add(100);
}

void replace(Card c) {
    c = new Card(0);
    c.add(5);
}

void main() {
    Card k = new Card(20);
    fill(k);
    replace(k);
    IO.println(k.getBalance());
}
