void main() {
    Zone zone1 = new Zone(1,"Centrum");
    Zone zone2 = new Zone(2,"Bussplan");
    Zone zone3 = new Zone(3,"S-market");

    TravelCard card1 = new TravelCard();
    TravelCard card2 = new TravelCard();
    IO.println(card1.toString());
    IO.println(card2.toString());

    card1.topUp(150);
    card2.topUp(3);

    Trip trip1 = new Trip(zone1, zone2);
    Trip trip2 = new Trip(zone2, zone1);

    card1.travel(trip1);
    card1.travel(trip2);
    IO.println("Kort 2 hade råd med resan: " + (card2.travel(trip2)));

    IO.println(card1.toString());
    IO.println(card2.toString());

    IO.println("Laddar kort med 700 euro: " + card1.topUp(700));
    IO.println("Betalar -4 euro: " + card1.pay(-4));

    IO.println("Totalt utfärdade kort: " + TravelCard.getIssuedCount());




}



