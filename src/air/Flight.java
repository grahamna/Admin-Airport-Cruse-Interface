package air;

import abs.TransportMethod;
import abs.TransportSection;
import local.*;

public class Flight extends TransportMethod{


    public Flight(Airport orig, Airport dest, Date date, String id) {
        super("Flight", id, orig, dest, date);
        
    }

    public FlightSection findFS(Flight flight, SeatClass s) {
        FlightSection fs=(FlightSection) findSection(flight, s);
        return fs;
    }

    public void addFlightSection(FlightSection fs, SeatClass s) {
        addTS(fs, s);

    }

    @Override
    public String toString(){
        String res = super.toString();
        for (TransportSection fs : getSectionList()) {
            res = res + ((FlightSection)fs).toString();
        }
        return res;
    }

}
