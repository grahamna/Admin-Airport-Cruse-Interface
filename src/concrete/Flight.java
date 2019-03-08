package concrete;

import java.util.ArrayList;

import seatClass.SeatClass;

public class Flight extends MySystem{

    private String ID;
    private FlightInfo fo;
    private ArrayList<FlightSection> flightSections = new ArrayList<>();

    private class FlightInfo extends MySystem{
        private Airport dest, orig;
        private Date date;

        private FlightInfo(String name, Airport origin, Airport destination, Date d){
            super(name);
            orig=origin;
            date=d;
            dest=destination;
        }

        String getInfo(){
            return getName()+": "+date.toString();
        }
    }

    Airport getDest(){
        return fo.dest;
    }
    Airport getOrig(){
        return fo.orig;
    }

    public Flight(String name, Airport orig, Airport dest, Date d, String id) {
        super(name);
        fo=new FlightInfo("Flight "+id+" from "+orig.getName()+" to "+dest.getName(), orig, dest, d);
        ID=id;
    }

    public void addSection(FlightSection fs){
        if(fs==null) {
            System.out.println("Flight section doesn't exist.");
        }
        else {
            flightSections.add(fs);
        }

    }

    public String getID() {
        return ID;
    }

    public String getInfo() {
        return fo.getInfo();
    }

    public FlightSection findFS(String flight, SeatClass s){
        for(FlightSection fs : this.flightSections){
            if (fs.getS() == s && fs.getFlight().ID.equals(flight)){
                return fs;
            }
        }
        return null;
    }

    public ArrayList<FlightSection> getFlightSections() {
        return flightSections;
    }

}
