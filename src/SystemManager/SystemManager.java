package SystemManager;

import java.util.HashSet;

import concrete.*;
import seatClass.*;

public class SystemManager {
    private HashSet<Airport> airports = new HashSet<Airport>();
    private HashSet<Airline> airlines = new HashSet<Airline>();

    public void createAirport(String n) {
        if(n.length() != 3) {
            System.out.println("Invalid input "+n+": Airport name must be 3 characters long.");
        }
        else {
            Airport airport = new Airport(n);
            if(airports.contains(airport)){
                System.out.println("Airport "+n+" already exists.");
            }
            else{
                airports.add(airport);
                System.out.println("Created airport "+n+".");
            }
        }
    }

    public void createAirline(String n) {
        if(n.length() > 5) {
            System.out.println("Invalid input "+n+": Airline name must be less than 6 characters long.");
        }
        else {
            Airline airline = new Airline(n);
            if(airlines.contains(airline)) {
                System.out.println("Airline "+n+" already exists.");
            }
            else{
                airlines.add(airline);
                System.out.println("Created airline "+n+".");
            }
        }
    }

    public void createFlight(String aname, String orig, String dest, int year, int month, int day, String id) {
        Airline al = new Airline(aname);
        if (airlines.contains(al)){
            if(orig.equals(dest)) {
                System.out.println("Originating airport ("+orig+") cannot be the same as the destination airport.");
            }
            else {
                Airport origin = new Airport(orig);
                Airport destination = new Airport(dest);
                if(airports.contains(origin) && airports.contains(destination)) {
                    Flight flight = new Flight(origin, destination, id, al);
                    al.addFlight(flight);
                    System.out.println("Created flight "+id+" from "+orig+" to "+dest+".");
                }
                else {
                    System.out.println("Airports "+orig+" and/or "+dest+" don't exist.");
                }
            }
        }
        else {
            System.out.println("Airline "+al.toString()+" missing");
        }
    }

    public void createSection(String alName, String flID, int rows, int cols, SeatClass s) {
        assert rows<101&&rows>0:"SysMan.createSection row peram error";
        assert cols<11&&cols>0:"SysMan.createSection col peram error";
        Airline tempAir = new Airline(alName);
        if (airlines.contains(tempAir)){
            Flight f = tempAir.findFlightByID(flID);
            if (f!=null){
                f.addSection(new FlightSection(f,rows,cols,s));
                System.out.println("Added Section to Flight "+f.toString());
            }
            else{
                System.out.println("Flight "+flID+" missing");
            }
        }
        else{
            System.out.println("Airline "+ tempAir.toString()+" missing");
        }

    }

    public void findAvailableFlights(String orig, String dest) {

    }

    public void bookSeat(String air, String fl, SeatClass s, int row, char col) {

    }

    public void displaySystemDetails() {

    }
}
