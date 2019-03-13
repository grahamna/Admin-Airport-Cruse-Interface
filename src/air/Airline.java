package air;

import java.util.ArrayList;

import abs.Company;

public class Airline extends Company{

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
                listAdd(flight);
            }
        }
    }

    public Flight findFlightByID(String id){
        return findMethodByID(id);
    }

    public void printFlightByPath(Airport from, Airport to){
        for(Flight f : getFlightList()){
            if (f.getOrig().equals(from) && f.getDest().equals(to)){
                System.out.println("Found matching flight:\n"+ f.getInfo()+".");
            }
        }
    }


}
