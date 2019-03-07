package concrete;

import java.util.HashSet;
import java.util.Iterator;

public class Airline extends MySystem{

    public HashSet<Flight> flightList = new HashSet<Flight>();

    public Airline(String n) {
        super(n);
    }

    public void addFlight(Flight flight){
        if(flight==null) {
            System.out.println(flight.getName()+" doesn't exist.");
        }
        else {
            if(findFlightByID(flight.getID())!=null) {
                System.out.println(flight.getName()+" already exists.");
            }
            else{
                flightList.add(flight);
            }
        }
    }

    public Flight findFlightByID(String id){
        for (Flight f : flightList) {
            if (f.getID().equals(id)){
                return f;
            }
        }
        return null;
    }

}
