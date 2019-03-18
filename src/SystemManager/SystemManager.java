package SystemManager;

import air.*;

import java.io.PrintStream;
import java.util.ArrayList;

import abs.*;
import local.*;

public class SystemManager {
    private ArrayList airports = new ArrayList<Airport>();

    public Airport searchAirports(Airport search) {
        return (Airport) search.searchPorts((Port)search, airports);
    }
    public Airport searchAirports(String search) {
        return (Airport) Port.searchPorts(search, airports);
    }

    public void addAirport(Airport ap) {
        airports.add(ap);
    }

    public ArrayList<Airport> getAirports() {
        return this.airports;
    }


    private ArrayList airlines = new ArrayList<Airline>();

    public Airline searchAirlines(Airline search) {
        return (Airline) search.searchCompanies((Company)search, airlines);
    }
    public Airline searchAirlines(String search) {
        return (Airline) Company.searchCompanies(search, airlines);
    
    }

    public void addAirline(Airline al) {
        airlines.add(al);
    }

    public ArrayList<Airline> getAirlines() {
        return this.airlines;
    }

    public void createAirport(String name) {
        System.out.println("Attempting to create Airport "+name+".");
        int charNumAirport = 3;
        if(name.length() != charNumAirport) {
            System.out.println("Invalid input "+name+": Airport name must be 3 characters long.\n");
        }
        else {
            Airport airport = new Airport(name);
            if(searchAirports(airport)!=null){
                System.out.println("Airport "+name+" already exists.\n");
            }
            else{
                addAirport(airport);
                System.out.println("Created airport "+name+".\n");
            }
        }
    }

    public void createAirline(String name) {
        System.out.println("Attempting to create Airline "+name+".");
        int charNumAirline = 5;
        if(name.length() > charNumAirline) {
            System.out.println("Invalid input "+name+": Airline name must be less than 6 characters long.\n");
        }
        else {
            Airline airline = new Airline(name);
            if(searchAirlines(airline)!=null) {
                System.out.println("Airline "+name+" already exists.\n");
            }
            else{
                addAirline(airline);
                System.out.println("Created airline "+name+".\n");
            }
        }
    }

    public void createFlight(String aname, String orig, String dest, int year, int month, int day, int hour, int min, String id) {
        System.out.println("Attempting to create Flight "+id+".");
        int minYear = 2018;
        int maxYear = 2019;
        int maxMonth = 12;
        int minDay = 1;
        int maxDay = 31;
        int minMonth = 1;
        int minHour=1;
        int maxHour=12;
        int maxMin = 59;
        int minMin = -0;
        if(orig.equals(dest)) {
            System.out.println("Originating airport ("+orig+") cannot be the same as the destination airport.\n");
        }
        else if((day<minDay || day>maxDay)||(month<minMonth || month>maxMonth) || (year<minYear || year> maxYear) || (hour>maxHour || hour<minHour) || (min>maxMin || min<minMin)) {
            System.out.println("Invalid date: "+month+"/"+day+"/"+year+".\n");
        }
        else if(searchAirlines(aname)==null) {
            System.out.println("Airline "+aname+" doesn't exist.\n");
        }
        else if(searchAirports(orig)==null) {
            System.out.println("Airport "+orig+" doesn't exist.\n");
        }
        else if(searchAirports(dest)==null) {
            System.out.println("Airport "+dest+" doesn't exist.\n");
        }
        else {
            Airline airline = searchAirlines(aname);
            Airport origin = searchAirports(orig);
            Airport destination = searchAirports(dest);
            Date date = new Date(month, day, year, hour, min);
            Flight flight = new Flight("Flight "+id, origin, destination, date, id);
            airline.addFlight(flight);
            System.out.println("Created flight "+id+" from "+orig+" to "+dest+".\n");
        }
    }

    public void createSection(String alName, String flID, int rows, char cols, SeatClass s, double cost) {
        System.out.println("Attempting to create Section for Flight "+flID+".");
        Airline airline = searchAirlines(alName);
        int maxRowSection = 101;
        int minRowSection = 0;
        int maxColSection = 11;
        int minColSection = 0;
        if((rows> maxRowSection ||rows< minRowSection) || (cols> maxColSection ||cols< minColSection)) {
            System.out.println("Invalid number of rows/columns: "+rows+" rows, "+cols+" columns.\n");
        }
        else if(airline==null) {
            System.out.println("Airline "+alName+" doesn't exist.\n");
        }
        else if(airline.findFlightByID(flID)==null){
            System.out.println("Flight "+flID+" doesn't exist.\n");
        }
        else {
            Flight flight = (Flight) airline.findFlightByID(flID);
            if (flight.findFS(flight, s)==null){
                FlightSection fs = new FlightSection(flight+" "+s+" class section", flight, rows, cols, s, cost);
                flight.addFlightSection(fs, s);
                System.out.println("Added "+fs+" to "+flight+".\n");
            }
            else {
                System.out.println("An identical flight section was found.\n");
            }
        }

    }

    public void findAvailableFlights(String orig, String dest) {
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

    public void bookSeat(String air, String fl, SeatClass s, int row, char col) {
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
