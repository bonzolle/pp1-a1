void main() {
    Card a = new Card(10);
    Card b = null;
    IO.println(b == null);

    b = a;
    a = null;
    IO.println(b.getBalance());
    IO.println(a.getBalance());
}
