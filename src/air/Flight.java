package air;

import java.util.ArrayList;

import abs.TransportMethod;
import local.Date;
import seatClass.SeatClass;

public class Flight extends TransportMethod{

    private String description;

    String getInfo(){
        return getName()+": "+getDate().toString();
    }
    @Override
    public String toString(){
        return this.description;
    }

    public Flight(String desc, Airport orig, Airport dest, Date date, String id) {
        super(id, orig, dest date);
        fo=new FlightInfo("Flight "+id+" from "+orig.toString()+" to "+dest.toString(), orig, dest, d);
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

    public String getInfo() {
        return fo.getInfo();
    }

    public FlightSection findFS(String flight, SeatClass s){
        for(FlightSection fs : getFlightSections()){
            if (fs.getS() == s && fs.getFlight().ID.equals(flight)){
                return fs;
            }
        }
        return null;
    }

    public ArrayList<FlightSection> getFlightSections() {
        return flightSections;
    }
	public String getName() {
		return null;
	}

}
