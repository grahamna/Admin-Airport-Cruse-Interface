package concrete;

import java.util.ArrayList;

public class Flight {

    public String ID;
    private FlightInfo fo;

    public class FlightInfo{
        private Airport dest, orig;
        private Airline airline;

        private FlightInfo(Airport dest, Airport orig, Airline al){
            this.dest=dest;
            this.orig=orig;
            this.airline=al;
        }
    }

    public ArrayList<FlightSection> flightSections = new ArrayList<FlightSection>();

    public Flight(Airport orig, Airport dest, String id, Airline al) {
        fo = new FlightInfo(dest, orig, al);
        this.ID=id;
    }

    public void addSection(FlightSection fs){
        assert fs!=null:"Flight.addSection peram error";
        flightSections.add(fs);
    }

}
