void main() {
    TravelCard card1 = new TravelCard();
    TravelCard card2 = new TravelCard();
    IO.println(card1.toString());
    card1.topUp(101);
    IO.println(card1.toString());
    card1.pay(100);
    IO.println(card1.toString());

    //printar card2
    IO.println(card2.toString());
    IO.println(TravelCard.getIssuedCount());

}