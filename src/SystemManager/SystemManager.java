package SystemManager;

import air.*;
import sea.*;

import java.io.PrintStream;
import java.util.ArrayList;

import abs.*;
import local.*;

public abstract class SystemManager {

    private ArrayList<Port> myPorts = new ArrayList<>();
    private ArrayList<Company> myCompanies = new ArrayList<>();

    public Port searchPorts(Port search) {
        return search.searchPorts(search, myPorts);
    }
    public Port searchPorts(String search) {
        return Port.searchPorts(search, myPorts);
    }
    public void addPort(Port ap) {
        myPorts.add(ap);
    }
    public ArrayList<Port> getPorts() {
        return myPorts;
    }

    public Company searchCompany(Company search) {
        return search.searchCompanies(search, myCompanies);
    }
    public Company searchCompany(String search) { return Company.searchCompanies(search, myCompanies); }
    public void addCompany(Company al) {
        myCompanies.add(al);
    }
    public ArrayList<Company> getCompanies() {
        return myCompanies;
    }

    public void createPort(String name,String type) {
        System.out.println("Attempting to create "+type+" "+name+".");
        int charNumAirport = 3;
        if(name.length() != charNumAirport) {
            System.out.println("Invalid input "+name+": "+type+" name must be 3 characters long.\n");
        }
        else{
            Port port;
            if (this instanceof AirSystemManager){
                port = new Airport(name);
            }
            else if (this instanceof SeaSystemManager){
                port = new Seaport(name);
            }
            else {
                throw new UnsupportedOperationException("SysMan not identified");
            }
            if(searchPorts(port)!=null){
                System.out.println(type+" "+name+" already exists.\n");
            }
            else{
                addPort(port);
                System.out.println("Created "+type+" "+name+".\n");
            }
        }
    }

    public void createCompany(String name,String type) {
        System.out.println("Attempting to create "+type+" "+name+".");
        int charNumAirline = 5;
        if(name.length() > charNumAirline) {
            System.out.println("Invalid input "+name+": "+type+" name must be less than 6 characters long.\n");
        }
        else {
            Company company;
            if (this instanceof AirSystemManager){
                company = new Airline(name);
            }
            else if (this instanceof SeaSystemManager){
                company = new Cruise(name);
            }
            else {
                throw new UnsupportedOperationException("SysMan not identified");
            }
            if(searchCompany(company)!=null) {
                System.out.println(type+" "+name+" already exists.\n");
            }
            else{
                addCompany(company);
                System.out.println("Created "+type+" "+name+".\n");
            }
        }
    }

    public void createTransportMethod(String aname, String orig, String dest, int year, int month, int day, int hour, int min, String id, String type) {
        System.out.println("Attempting to create "+type+" "+id+".");
        int minYear = 2018;
        int maxYear = 2020;
        int maxMonth = 12;
        int minDay = 1;
        int maxDay = 31;
        int minMonth = 1;
        int minHour=1;
        int maxHour=24;
        int maxMin = 59;
        int minMin = 0;
        if(orig.equals(dest)) {
            System.out.println("Originating port ("+orig+") cannot be the same as the destination port.\n");
        }
        else if((day<minDay || day>maxDay)||(month<minMonth || month>maxMonth) || (year<minYear || year>maxYear) || (hour>maxHour || hour<minHour) || (min>maxMin || min<minMin)) {
            System.out.println("Invalid date: "+month+"/"+day+"/"+year+".\n");
        }
        else if(searchCompany(aname)==null) {
            System.out.println(type+" "+aname+" doesn't exist.\n");
        }
        else if(searchPorts(orig)==null) {
            System.out.println("Port "+orig+" doesn't exist.\n");
        }
        else if(searchPorts(dest)==null) {
            System.out.println("Port "+dest+" doesn't exist.\n");
        }
        else {
            Company company = searchCompany(aname);
            Port origin = searchPorts(orig);
            Port destination = searchPorts(dest);
            Date date = new Date(month, day, year, hour, min);
            if (this instanceof AirSystemManager){
                Flight flight = new Flight((Airport)origin, (Airport) destination, date, id);
                ((Airline)company).addFlight(flight);
                System.out.println("Created "+type+" "+id+" from "+orig+" to "+dest+".\n");
            }
            else if (this instanceof SeaSystemManager) {
                Ship ship = new Ship((Seaport)origin, (Seaport) destination, date, id);
                ((Cruise)company).addShip(ship);
                System.out.println("Created "+type+" "+id+" from "+orig+" to "+dest+".\n");
            }
            else {
                throw new UnsupportedOperationException("SysMan not identified");
            }
        }
    }

    public void createSection(String alName, String flID, int rows, char layout, SeatClass s, double cost, String type) {
        System.out.println("Attempting to create Section for Flight "+flID+".");
        Company company = searchCompany(alName);
        int maxRowSection = 101;
        int minRowSection = 0;
        if(rows> maxRowSection ||rows< minRowSection) {
            System.out.println("Invalid number of rows/columns: "+rows+" rows\n");
        }
        else if(company==null) {
            System.out.println("Company "+alName+" doesn't exist.\n");
        }
        else if(company.findMethodByID(flID)==null){
            System.out.println("TransportMethod "+flID+" doesn't exist.\n");
        }
        else {
            if (this instanceof AirSystemManager){
                Flight flight = (Flight) company.findMethodByID(flID);
                if (flight.findFS(flight, s)==null){
                    FlightSection fs = new FlightSection(flID, flight, rows, layout, s, cost);
                    flight.addFlightSection(fs, s);
                    System.out.println("Added "+fs+" to "+flight+".\n");
                }
                else if (this instanceof SeaSystemManager){
                    Ship Ship = (Ship) company.findMethodByID(flID);
                    if (Ship.findCS(Ship, s)==null){
                        CabinSection fs = new CabinSection(flID, Ship, rows, layout, s, cost);
                        Ship.addCabinSection(fs, s);
                        System.out.println("Added "+fs+" to "+Ship+".\n");
            }
                }
                else {
                    System.out.println("An identical "+type+" section was found.\n");
                }
            }
        }

    }

    public void findAvailablePath(String orig, String dest) {
        System.out.println("Attempting to find path from "+orig+" to "+dest+".");
        Port from = searchPorts(orig);
        Port to = searchPorts(dest);
        if (from!=null && to!=null){
            for(Company al : getCompanies()){
                if (this instanceof AirSystemManager){
                    ((Airline)al).flightPathFinder((Airport)from, (Airport)to);
                }
                else if(this instanceof SeaSystemManager){
                    ((Cruise)al).shipPathFinder((Seaport)from, (Seaport)to);
                }
                else{
                    throw new UnsupportedOperationException("SysMan not identified");
                }
            }
            System.out.println();
        }
        else{
            System.out.println("Unexpected error occured.\n");
        }
    }

    public void bookContainer(String air, String fl, SeatClass s, int row, char col) {
        System.out.println("Attempting to book seat "+s+" "+row+" "+col+" for "+fl+".");
        Company Cruse = searchCompany(air);
        if(Cruse!=null){
            TransportMethod Ship = Cruse.findMethodByID(fl);
            if (Ship!=null){
                if (this instanceof AirSystemManager){
                    FlightSection fs =  ((Flight)Ship).findFS((Flight)Ship, s);
                if (fs!=null && fs.hasAvalableFlightSeats()){
                    FlightSeat seat = fs.findFlightSeat(row, col);
                    if (seat!=null && fs.isSeatAvailable(row, col)){
                        seat.bookContainer();;
                        System.out.println("Booked "+fs+" Seat "+seat+" on "+ Ship+".\n");
                    }
                    else{
                        System.out.println("Seat not available.\n");
                    }
                }
            }
                else if (this instanceof SeaSystemManager){
                    CabinSection cs = ((Ship)Ship).findCS((Ship) Ship, s);
                    if (cs!=null && cs.hasAvailableCabins()){
                        Cabin seat = cs.findCabin(row, col);
                        if (seat!=null && cs.isCabinAvailable(row, col)){
                            seat.bookContainer();
                            System.out.println("Booked "+cs+" Seat "+seat+" on "+ Ship+".\n");
                        }
                        else{
                            System.out.println("Seat not available.\n");
                        }
                    }
                }
                else{
                    System.out.println("Section not available.\n");
                }
            }
            else{
                System.out.println("Transport not available.\n");
            }
        }
        else{
            System.out.println("Company not available.\n");
        }
    }

    public void displaySystemDetails(PrintStream out) {
        StringBuilder res1 = new StringBuilder("[");
        for (Port p : getPorts()) {
            if (this instanceof AirSystemManager){
                res1.append(((Airport) p).toString());
            }
            else if (this instanceof SeaSystemManager){

                res1.append(((Seaport) p).toString());
            }
        }
        res1.append("]");
        out.print(res1);
        StringBuilder res2 = new StringBuilder("{");
        for (Company al : getCompanies()) {
            if (this instanceof AirSystemManager){
                res2.append(((Airline) al).toString());
            }
            else if (this instanceof SeaSystemManager){
                res2.append(((Cruise) al).toString());
            }
        }
        res2.append("}");
        out.print(res2);
    }
}
