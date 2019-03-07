package concrete;

import java.util.ArrayList;

import seatClass.SeatClass;

public class Flight extends MySystem{

    public String ID;
    private FlightInfo fo;
    private ArrayList<FlightSection> flightSections = new ArrayList<FlightSection>();

    private class FlightInfo extends MySystem{
        private Airport dest, orig;
        private Airline airline;
        private Date date;

        private FlightInfo(String name, Airport origin, Airport destination, Date d, Airline al){
            super(name);
            orig=origin;
            date=d;
            dest=destination;
            airline=al;
        }

        String getInfo(){
            return getName()+": "+date.toString();
        }
    }

    public Flight(String name, Airport orig, Airport dest, Date d, String id, Airline al) {
        super(name);
        fo=new FlightInfo("Flight "+id+" from "+orig.getName()+" to "+dest.getName(), dest, orig, d, al);
        ID=id;
    }

    public void addSection(FlightSection fs){
        if(fs==null) {
            System.out.println("Flight section doen't exist.");
        }
        else {
            flightSections.add(fs);
        }

    }

    String getID() {
        return ID;
    }

    public String getInfo() {
        return fo.getInfo();
    }

    public FlightSection findFS(String flight, SeatClass s){
        for(FlightSection fs : this.flightSections){
            if (fs.s == s && fs.flight.ID.equals(flight)){
                return fs;
            }
        }
        return null;
    }

    public Airport getDest(){
        return this.fo.dest;
    }
    public Airport getOrig(){
        return this.fo.orig;
    }

}
