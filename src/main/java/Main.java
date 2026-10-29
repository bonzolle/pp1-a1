void main() {
    TravelCard card1 = new TravelCard();
    TravelCard card2 = new TravelCard();
    IO.println(card1.toString());
    card1.topUp(101);
    IO.println(card1.toString());

    //printar card2
    IO.println(card2.toString());

    // Skapar zoner

    Zone zone1 = new Zone(1,"Centrum");
    Zone zone2 = new Zone(2,"Bussplan");
    Zone zone3 = new Zone(3,"S-market");

    Trip trip1 = new Trip(zone1,zone3);
    IO.println(trip1.toString());


    card1.travel(trip1);

    IO.println("this the last print" + card1);


}



