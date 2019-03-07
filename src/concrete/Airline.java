package concrete;

import java.util.HashSet;
import java.util.Iterator;

public class Airline extends MySystem{

    public HashSet<Flight> flightList = new HashSet<Flight>();

    public Airline(String n) {
        super(n);
    }

    public void addFlight(Flight flight){
        assert flight!=null:"bad peram Airline.addFlight";
        if (flightList.contains(flight)){
            System.out.println("Identical flight already found");
        }
        else{
            flightList.add(flight);
        }
    }

    public Flight findFlightByID(String id){
        for (Flight f : flightList) {
            if (f.ID.equals(id)){
                return f;
            }
        }
        return null;
    }

}
