import java.util.ArrayList;

class Flight {
    private Airport origin;
    private Airport destination;
    private String ID;
    ArrayList<FlightSection> flightSections = new ArrayList<>();
    Flight(Airport orig, Airport dest, String id) {
        origin = orig;
        destination = dest;
        ID = id;
    }
}
