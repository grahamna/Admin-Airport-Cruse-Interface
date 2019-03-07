package SystemManager;

import java.util.ArrayList;

import concrete.*;
import seatClass.*;

public class SystemManager {
    private ArrayList<Airport> airports = new ArrayList<Airport>();
    private ArrayList<Airline> airlines = new ArrayList<Airline>();

    public void createAirport(String n) {
        if(n.length() != 3) {
            System.out.println("Invalid input "+n+": Airport name must be 3 characters long.");
        }
        else {
            if(hasAirport(n)){
                System.out.println("Airport "+n+" already exists.");
            }
            else{
                airports.add(new Airport(n));
                System.out.println("Created airport "+n+".");
            }
        }
    }

    public void createAirline(String n) {
        if(n.length() > 5) {
            System.out.println("Invalid input "+n+": Airline name must be less than 6 characters long.");
        }
        else {
            if(hasAirline(n)) {
                System.out.println("Airline "+n+" already exists.");
            }
            else{
                airlines.add(new Airline(n));
                System.out.println("Created airline "+n+".");
            }
        }
    }

    public void createFlight(String aname, String orig, String dest, int year, int month, int day, String id) {
        if (!(hasAirline(aname))){
            Airline al = getAirline(aname);
            if(orig.equals(dest)) {
                System.out.println("Originating airport ("+orig+") cannot be the same as the destination airport.");
            }
            else {
                Airport origin = new Airport(orig);
                Airport destination = new Airport(dest);
                if(airports.contains(origin) && airports.contains(destination)) {
                    if((day<1 || day>31)||(month<1 || month>12)) {
                        System.out.println("Invalid date: "+month+"/"+day+"/"+year+".");
                    }
                    else{
                        Date date = new Date(month, day, year);
                        Flight flight = new Flight(origin, destination, id, al, date);
                        al.addFlight(flight);
                        System.out.println("Created flight "+id+" from "+orig+" to "+dest+".");
                    }
                }
                else {
                    System.out.println("Airports "+orig+" and/or "+dest+" don't exist.");
                }
            }
        }
        else {
            System.out.println("Airline "+aname+" missing");
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
        if (hasAirline(air)){
            Airline al = getAirline(air);
            Flight flight = al.findFlightByID(fl);
            if (flight!=null){
                flight.findFS(flight.ID, s);
            }
        }
    }

    public void displaySystemDetails() {

    }


    public boolean hasAirport(String s){
        for(Airport a : this.airports) {
            if (a.name.equals(s)){
                return true;
            }
        }
        return false;
    }

    public Airport getAirport(String s) {
        for(Airport a : this.airports) {
            if (a.name.equals(s)){
                return a;
            }
        }
        return null;
    }

    public boolean hasAirline(String s){
        for(Airline a : this.airlines) {
            if (a.name.equals(s)){
                return true;
            }
        }
        return false;
    }

    public Airline getAirline(String s) {
        for(Airline a : this.airlines) {
            if (a.name.equals(s)){
                return a;
            }
        }
        return null;
    }

    public FlightSection findFS(String flight, SeatClass s){
        for(FlightSection fs : flightSections){
            if (fs.s == s && fs.flight.ID.equals(flight)){
                return fs;
            }
        }
        return null;
    }
}
