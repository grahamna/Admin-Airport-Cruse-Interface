package SystemManager;

import air.*;

import java.io.PrintStream;
import java.util.ArrayList;

import abs.*;
import local.*;

public abstract class SystemManager {

    public void createPort(String name) {
        System.out.println("Attempting to create Airport "+name+".");
        int charNumAirport = 3;
        if(name.length() != charNumAirport) {
            System.out.println("Invalid input "+name+": Airport name must be 3 characters long.\n");
        }
    }

    public void createCompany(String name) {
        System.out.println("Attempting to create Airline "+name+".");
        int charNumAirline = 5;
        if(name.length() > charNumAirline) {
            System.out.println("Invalid input "+name+": Airline name must be less than 6 characters long.\n");
        }
    }

    public void findAvailablePaths(String orig, String dest) {
        System.out.println("Attempting to find Flight from "+orig+" to "+dest+".");
        Airport from = searchAirports(orig);
        Airport to = searchAirports(dest);
        if (from!=null && to!=null){
            for(Airline al : getAirlines()){
                al.flightPathFinder(from, to);
            }
            System.out.println();
        }
        else{
            System.out.println("Unexpected error occured.\n");
        }
    }

    public void bookContainer(String air, String fl, SeatClass s, int row, char col) {
        System.out.println("Attempting to book seat "+s+" "+row+" "+col+" for Flight "+fl+".");
        Airline airline = searchAirlines(air);
        if(airline!=null){
            Flight flight = airline.findFlightByID(fl);
            if (flight!=null){
                FlightSection fs = flight.findFS(flight, s);
                if (fs!=null && fs.hasAvalableFlightSeats()){
                    FlightSeat seat = fs.findFlightSeat(row, col);
                    if (seat!=null && fs.isSeatAvailable(row, col)){
                        seat.bookContainer();;
                        System.out.println("Booked "+fs+" Seat "+seat+" on "+ flight+".\n");
                    }
                    else{
                        System.out.println("Seat not available.\n");
                    }
                }
                else{
                    System.out.println("Flight section not available.\n");
                }
            }
            else{
                System.out.println("Flight not available.\n");
            }
        }
        else{
            System.out.println("Airline not available.\n");
        }
    }

    public void displaySystemDetails(PrintStream out) {
        String res1 = "[";
        for (Port p : getAirports()) {
            res1 = res1 + p.toString();
        }
        res1 = res1 + "]";
        out.print(res1);
        String res2 = "{";
        for (Airline al : getAirlines()) {
            res2=res2+al.toString();
        }
        res2=res2+"}";
        out.print(res2);
    }
}
