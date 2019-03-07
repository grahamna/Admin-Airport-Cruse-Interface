package concrete;

import seatClass.FlightSection;

import java.util.ArrayList;

public class Flight {
    private Airport origin;
    private Airport destination;
    private String ID;
    private Date date;
    ArrayList<FlightSection> flightSections = new ArrayList<>();
    public Flight(Airport orig, Airport dest, Date dt, String id) {
        origin = orig;
        destination = dest;
        ID = id;
        date=dt;
    }
}
