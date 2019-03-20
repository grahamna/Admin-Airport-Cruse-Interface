package SystemManager;

import air.*;


import abs.*;
import local.*;

public class AirSystemManager extends SystemManager {

    public Airport searchAirports(Airport search) {
        return (Airport) searchPorts(search);
    }
    public Airport searchAirports(String search) {
        return (Airport) Port.searchPorts(search, myPorts);
    }

    public void addAirport(Airport ap) {
        myPorts.add(ap);
    }

    public Airline searchAirlines(Airline search) {
        return (Airline)searchCompany(search);
    }
    public Airline searchAirlines(String search) {
        return (Airline) Company.searchCompanies(search, myCompany);
    
    }

    public void addAirline(Airline al) {
        myCompany.add(al);
    }

    public void createAirport(String name) {
        createPort(name,"Airport");
    }
    

    public void createAirline(String name) {
        createCompany(name,"Airline");
        
    }

    public void createFlight(String aname, String orig, String dest, int year, int month, int day, int hour, int min, String id) {
        createTransportMethod(aname, orig, dest, year, month, day, hour, min, id, "Flight");
    }

    public void createSection(String alName, String flID, int rows, char layout, SeatClass s, double cost) {
        createSection(alName, flID, rows, layout, s, cost, "Flight");
    }

    public void findAvailableFlights(String orig, String dest) {
        findAvailablePath(orig, dest);
    }

    public void bookSeat(String air, String fl, SeatClass s, int row, char col) {
        bookContainer(air, fl, s, row, col);
    }

}
