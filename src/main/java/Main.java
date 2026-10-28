void main() {
    TravelCard card1 = new TravelCard(1,100);
    IO.println(card1.toString());
    card1.topUp(100);
    IO.println(card1.toString());
    card1.pay(100);
    IO.println(card1.toString());
}