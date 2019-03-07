package SystemManager;

import concrete.*;
import seatClass.*;

import java.util.HashSet;

public class SystemManager {
    private HashSet<Airport> airports = new HashSet<Airport>();
    private HashSet<Airline> airlines = new HashSet<Airline>();
    MySystem sd = new SystemDetails();

    public void createAirport(String n) {
        if(n.length() != 3) {
            System.out.println("Invalid input "+n+": Airport name must be 3 characters long.");
        }
        else {
            Airport airport = new Airport(n);
            if(searchAirports(n)!=null) {
               System.out.println("Airport "+n+" already exists.");
            }
            else{
                airports.add(airport);
                System.out.println("Created airport "+n+".");
                sd = new Airport(n, sd);
            }
        }
    }

    public void createAirline(String n) {
        if(n.length() > 5) {
            System.out.println("Invalid input "+n+": Airline name must be less than 6 characters long.");
        }
        else {
            Airline airline = new Airline(n);
            if(searchAirlines(n)!=null) {
                System.out.println("Airline "+n+" already exists.");
            }
            else{
                airlines.add(airline);
                System.out.println("Created airline "+n+".");
                sd = new Airline(n, sd);
            }
        }
    }

    Airline searchAirlines(String n) {
        for(Airline al: airlines){
            if(al.getName().equals(n)) {
                return al;
            }
        }
        return null;
    }

    Airport searchAirports(String n) {
        for(Airport ap: airports) {
            if(ap.getName().equals(n)) {
                return ap;
            }
        }
        return null;
    }

    public void createFlight(String aname, String orig, String dest, int year, int month, int day, String id) {
        Airline al = searchAirlines(aname);
        if(orig.equals(dest)) {
            System.out.println("Originating airport ("+orig+") cannot be the same as the destination airport.");
        }
        else {
            Airport origin = searchAirports(orig);
            Airport destination = searchAirports(dest);
            if(origin != null && destination != null) {
                if((day<1 || day>31)||(month<1 || month>12)) {
                    System.out.println("Invalid date: "+month+"/"+day+"/"+year+".");
                }
                else {
                    Date date = new Date(month, day, year);
                    Flight flight = new Flight(origin, destination, date, id);
                    System.out.println("Created flight "+id+" from "+orig+" to "+dest+".");
                }
            }
            else {
                System.out.println("Airports "+orig+" and/or "+dest+" don't exist.");
            }
        }
    }

    public void createSection(String air, String flID, int rows, int cols, SeatClass s) {

    }

    public void findAvailableFlights(String orig, String dest) {

    }

    public void bookSeat(String air, String fl, SeatClass s, int row, char col) {

    }

    public void displaySystemDetails() {
        System.out.println(sd.info());
    }

}
