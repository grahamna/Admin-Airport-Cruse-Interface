package air;

import abs.TransportMethod;
import abs.TransportSection;
import local.*;

import java.util.HashSet;

public class Flight extends TransportMethod{

    private HashSet<TransportSection> flightSections;

    public Flight(String type, Airport orig, Airport dest, Date date, String id) {
        super("Flight", id, orig, dest, date);
        
    }

    public FlightSection findFS(Flight flight, SeatClass s) {
        FlightSection fs=(FlightSection)super.findSection(flight, s, flightSections);
        return fs;
    }

    public void addFlightSection(FlightSection fs, SeatClass s) {
        super.addTS(fs, s, flightSections);

    }

}
