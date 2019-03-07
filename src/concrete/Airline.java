package concrete;

import java.util.HashSet;

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

    @Override
    public String info() {
    //    return sd.info() + "\nAirline "+getName();
    return null;
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
