package concrete;

import java.util.ArrayList;
import seatClass.*;

public class Flight {
    private Airport origin;
    private Airport destination;
    private String ID;
    ArrayList<FlightSection> flightSections = new ArrayList<>();
    public Flight(Airport orig, Airport dest, String id) {
        origin = orig;
        destination = dest;
        ID = id;
    }
}
