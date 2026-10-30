
public class Trip {
    private int price;
    private Zone from;
    private Zone to;
    private static final int baseCost = 3;


    public Trip(Zone from, Zone to) {
    this.price = baseCost + Math.abs(from.getNumber() - to.getNumber());
    this.from = from;
    this.to = to;
    }

    public int getPrice(){
    return price;
    }
    Zone getFrom(){
        return from;
    }
    Zone getTo(){
    return to;
    }
    @Override
    public String toString() {
        return "Trip: " + getFrom() + " To-> " + getTo() + " (" + getPrice()+ ")";
    }
}
