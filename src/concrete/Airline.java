package concrete;

import java.util.HashSet;

public class Airline extends MySystem{

    private HashSet<Flight> flightList = new HashSet<>();

    public Airline(String n) {
        super(n);
    }

    public void addFlight(Flight flight){
        if(flight==null) {
            System.out.println("Flight doesn't exist.");
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
        for (Flight f : this.flightList) {
            if (f.getID().equals(id)){
                return f;
            }
        }
        return null;
    }

    public void printFlightByPath(Airport from, Airport to){
        for(Flight f : this.flightList){
            if (f.getOrig().equals(from) && f.getDest().equals(to)){
                System.out.println("Found matching flight:\n"+ f.getInfo()+".");
            }
        }
    }

    public HashSet<Flight> getFlightList() {
        return flightList;
    }


}
