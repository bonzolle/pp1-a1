void main() {
    Card a = new Card(50);
    Card b = a;
    b.add(30);
    IO.println(a.getBalance());
    IO.println(b.getBalance());
}
