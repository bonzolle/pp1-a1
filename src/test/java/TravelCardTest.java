import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TravelCardTest {

    private final Zone z1 = new Zone(1, "Centrum");
    private final Zone z2 = new Zone(2, "Hamnen");
    private final Zone z3 = new Zone(3, "Flygfältet");

    @Test
    void newCardIsEmpty() {
        var card = new TravelCard();
        assertEquals(0, card.getBalance());
        assertEquals(0, card.getTripCount());
        assertNull(card.getLastTrip());
    }

    @Test
    void numbersAreConsecutiveAndUnique() {
        var a = new TravelCard();
        var b = new TravelCard();
        assertEquals(a.getNumber() + 1, b.getNumber());
        assertTrue(a.getNumber() >= 1001);
    }

    @Test
    void issuedCountFollowsCreatedCards() {
        int before = TravelCard.getIssuedCount();
        new TravelCard();
        new TravelCard();
        assertEquals(before + 2, TravelCard.getIssuedCount());
    }

    @Test
    void topUpAddsToBalance() {
        var card = new TravelCard();
        assertTrue(card.topUp(100));
        assertTrue(card.topUp(50));
        assertEquals(150, card.getBalance());
    }

    @Test
    void topUpRejectsZeroAndNegative() {
        var card = new TravelCard();
        assertFalse(card.topUp(0));
        assertFalse(card.topUp(-10));
        assertEquals(0, card.getBalance());
    }

    @Test
    void topUpRespectsMaxBalance() {
        var card = new TravelCard();
        assertTrue(card.topUp(200));
        assertFalse(card.topUp(1));
        assertEquals(200, card.getBalance());

        var other = new TravelCard();
        other.topUp(180);
        assertFalse(other.topUp(30));
        assertEquals(180, other.getBalance());
    }

    @Test
    void payRemovesFromBalance() {
        var card = new TravelCard();
        card.topUp(100);
        assertTrue(card.pay(30));
        assertEquals(70, card.getBalance());
        assertTrue(card.pay(70));
        assertEquals(0, card.getBalance());
    }

    @Test
    void payRejectsInvalidAmounts() {
        var card = new TravelCard();
        card.topUp(50);
        assertFalse(card.pay(0));
        assertFalse(card.pay(-5));
        assertFalse(card.pay(51));
        assertEquals(50, card.getBalance());
    }

    @Test
    void tripPriceDependsOnZones() {
        assertEquals(3, new Trip(z1, z1).getPrice());
        assertEquals(4, new Trip(z1, z2).getPrice());
        assertEquals(5, new Trip(z3, z1).getPrice());
    }

    @Test
    void travelPaysAndRemembersTrip() {
        var card = new TravelCard();
        card.topUp(100);
        var trip = new Trip(z1, z3);

        assertTrue(card.travel(trip));

        assertEquals(95, card.getBalance());
        assertEquals(1, card.getTripCount());
        assertSame(trip, card.getLastTrip());
    }

    @Test
    void failedTravelChangesNothing() {
        var card = new TravelCard();
        card.topUp(7);
        var first = new Trip(z1, z1);
        card.travel(first);

        assertFalse(card.travel(new Trip(z1, z3)));

        assertEquals(4, card.getBalance());
        assertEquals(1, card.getTripCount());
        assertSame(first, card.getLastTrip());
    }

    @Test
    void travelWithNullIsRejected() {
        var card = new TravelCard();
        card.topUp(100);
        assertFalse(card.travel(null));
        assertEquals(100, card.getBalance());
        assertEquals(0, card.getTripCount());
    }

    @Test
    void toStringWorksBeforeFirstTrip() {
        var card = new TravelCard();
        assertNotNull(card.toString());
        assertTrue(card.toString().contains(String.valueOf(card.getNumber())));
    }

    @Test
    void noPublicMutableFieldsAndNoSetters() {
        for (Class<?> c : new Class<?>[] {TravelCard.class, Trip.class}) {
            for (Field f : c.getDeclaredFields()) {
                int m = f.getModifiers();
                if (Modifier.isPublic(m)) {
                    assertTrue(Modifier.isStatic(m) && Modifier.isFinal(m),
                        c.getSimpleName() + "." + f.getName() + " är publikt och kan ändras");
                }
            }
            for (Method method : c.getDeclaredMethods()) {
                assertFalse(method.getName().startsWith("set"),
                    c.getSimpleName() + " har en setter: " + method.getName());
            }
        }
    }
}
