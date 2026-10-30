# Del D: Reflektion

Högst en sida.

1. Första regeln kan inte brytas för att fälten skyddas med defintionen private.
Andra regeln kan inte heller bytas då jag satte en if sats som kollar ifall det inmatade värdet är negativt.
Tredje regeln bygger lite på den första och det är att man inte ska kunna anropa fälten direkt utan att metoderna enbart för röra fälten.

2. Är i princip samma saka som att skriva direkt i fältet. Enligt uppgiften går det emot reglerna eftersom vi inte bör använda setters.
3. Balance är objektbaserat, varje objekt har sin egna balance. Ett statiskt värde är ett värde som alla har tillgång till (alltså är samma för alla).
Skulle man välja att inte ha nextNumber statiskt skulle det sparas som ett nytt minnesblock i varje objekt istället för att spara minne och bara peka på samma fält.

4. Detg finns bara ett Trip objekt då vi enbart skapar en. Vi läser in det objektet i travel. 

println kommer skriva ut false även fast innehållet kan vara samma, det är för att det är ifrån olika objekt och lastrip i ada pekar på en annan plats i minnet (heapen)

Kan något som görs med
Adas kort ändra Bos senaste resa?

Man behöver anropa Bo för att kunna ändra på lastTrip. LastTrip uppdateras bara om metoden travel() används och uppdateras här:   lastTrip = trip.getFrom() + " to " + trip.getTo() +" " + trip.getPrice() + " euros" ;

även om man skriver  Ada.travel(Bo.travel(trip1)); kommer det inte gå eftersom travel() enbart returner boolska värden och inte objekt...

5. Det svåraste i uppgiften var nog C för jag hade fastnat på Trip konstruktorn, jag förstod inte föräns handledning vad jag skulle göra.
## Tidsåtgång (fråga 5)

| Del | Timmar |
|-----|--------|
| A   |     0,5   |
| B   |    0,5    |
| C   |   2,5  - 3   |
| D   |      0,5  |
