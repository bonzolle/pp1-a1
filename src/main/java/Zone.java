/**
 * En taxezon i kollektivtrafiken, till exempel "Zon 1 (Centrum)".
 *
 * Modellklass för inlämning 1: den visar hur en inkapslad klass ser ut.
 * Läs kommentarerna och använd samma mönster i dina egna klasser.
 */
public class Zone {

    // Fälten är private: ingen kod utanför klassen kan läsa eller ändra dem direkt.
    // De är också final: de tilldelas en gång i konstruktorn och ändras sedan aldrig.
    private final int number;
    private final String name;

    // Konstruktorn har samma namn som klassen och ingen returtyp.
    // Den körs när någon skriver new Zone(1, "Centrum") och ger fälten sina värden.
    public Zone(int number, String name) {
        // this.number är fältet, number är parametern.
        this.number = number;
        this.name = name;
    }

    // Getters ger läsrätt utan att ge skrivrätt. Det finns inga setters,
    // eftersom en zon aldrig byter nummer eller namn.
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    // toString anropas automatiskt när objektet skrivs ut, t.ex. med IO.println(zone).
    // @Override betyder att vi ersätter den toString som alla klasser ärver.
    @Override
    public String toString() {
        return "Zon " + number + " (" + name + ")";
    }
}
