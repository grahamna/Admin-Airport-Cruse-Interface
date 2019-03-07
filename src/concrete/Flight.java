package concrete;

import java.util.ArrayList;

import seatClass.SeatClass;

public class Flight {

    public String ID;
    private FlightInfo fo;

    public class FlightInfo{
        private Airport dest, orig;
        private Airline airline;
        private Date date;

        private FlightInfo(Airport dest, Airport orig, Airline al, Date date){
            this.dest=dest;
            this.orig=orig;
            this.airline=al;
            this.date=date;
        }
    }

    public ArrayList<FlightSection> flightSections = new ArrayList<FlightSection>();

    public Flight(Airport orig, Airport dest, String id, Airline al, Date date) {
        fo = new FlightInfo(dest, orig, al, date);
        this.ID=id;
    }

    public void addSection(FlightSection fs){
        assert fs!=null:"Flight.addSection peram error";
        flightSections.add(fs);
    }

    public FlightSection findFS(String flight, SeatClass s){
        for(FlightSection fs : this.flightSections){
            if (fs.s == s && fs.flight.ID.equals(flight)){
                return fs;
            }
        }
        return null;
    }

}
