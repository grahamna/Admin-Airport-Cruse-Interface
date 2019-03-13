package air;

import java.util.ArrayList;

import abs.Company;

public class Airline extends Company{

    public Airline(String n) {
        super("Airline",n);
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



}
