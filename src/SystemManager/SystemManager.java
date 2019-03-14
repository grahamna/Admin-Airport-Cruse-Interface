package SystemManager;

import java.util.HashSet;


public class SystemManager {

    private final int charNumAirport = 3;
    private final int charNumAirline = 5;

    private Airline searchAirlines(String n) {
        for(Airline al: this.airlines){
            if(al.getName().equals(n)) {
                return al;
            }
        }
        return null;
    }

    private Airport searchAirports(String n) {
        for(Airport ap: this.airports) {
            if(ap.getName().equals(n)) {
                return ap;
            }
        }
        return null;
    }

    public void createAirport(String name) {
        System.out.println("Attempting to create Airport "+name+".");
        if(name.length() != charNumAirport) {
            System.out.println("Invalid input "+name+": Airport name must be 3 characters long.\n");
        }
        else {
            Airport airport = new Airport(name);
            if(searchAirports(name)!=null){
                System.out.println("Airport "+name+" already exists.\n");
            }
            else{
                airports.add(airport);
                System.out.println("Created airport "+name+".\n");
            }
        }
    }

    public void createAirline(String name) {
        System.out.println("Attempting to create Airline "+name+".");
        if(name.length() > charNumAirline) {
            System.out.println("Invalid input "+name+": Airline name must be less than 6 characters long.\n");
        }
        else {
            Airline airline = new Airline(name);
            if(searchAirlines(name)!=null) {
                System.out.println("Airline "+name+" already exists.\n");
            }
            else{
                airlines.add(airline);
                System.out.println("Created airline "+name+".\n");
            }
        }
    }

    private final int minDay = 1;
    private final int maxDay = 31;
    private final int minMonth = 1;
    private final int maxMonth = 12;
    private final int minYear = 2018;
    private final int maxYear = 2019;
    public void createFlight(String aname, String orig, String dest, int year, int month, int day, String id) {
        System.out.println("Attempting to create Flight "+id+".");
        if(orig.equals(dest)) {
            System.out.println("Originating airport ("+orig+") cannot be the same as the destination airport.\n");
        }
        else if((day<minDay || day>maxDay)||(month<minMonth || month>maxMonth| (year<minYear|year>maxYear))) {
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
            Airline al = searchAirlines(aname);
            Airport origin = searchAirports(orig);
            Airport destination = searchAirports(dest);
            Date date = new Date(month, day, year);
            Flight flight = new Flight("Flight "+id, origin, destination, date, id);
            al.addFlight(flight);
            System.out.println("Created flight "+id+" from "+orig+" to "+dest+".\n");
        }
    }

    private final int maxRowSection = 101;
    private final int minRowSection = 0;
    private final int maxColSection = 11;
    private final int minColSection = 0;
    public void createSection(String alName, String flID, int rows, int cols, SeatClass s) {
        System.out.println("Attempting to create Section for Flight "+flID+".");
        Airline al = searchAirlines(alName);
        if((rows>maxRowSection||rows<minRowSection) || (cols>maxColSection||cols<minColSection)) {
            System.out.println("Invalid number of rows/columns: "+rows+" rows, "+cols+" columns.\n");
        }
        else if(al==null) {
            System.out.println("Airline "+alName+" doesn't exist.\n");
        }
        else if(al.findFlightByID(flID)==null){
            System.out.println("Flight "+flID+" doesn't exist.\n");
        }
        else {
            Flight flight = al.findFlightByID(flID);
            if (flight.findFS(flight.getID(), s)==null){
                FlightSection fs = new FlightSection(flight.getName()+" "+s+" class section", flight, rows, cols,s);
                flight.addSection(fs);
                System.out.println("Added "+fs.getName()+" to "+flight.getName()+".\n");
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
            for(Airline al : airlines){
                al.printFlightByPath(from, to);
            }
            System.out.println();
        }
        else{
            System.out.println("Unexpected error occured.\n");
        }
    }

    public void bookSeat(String air, String fl, SeatClass s, int row, char col) {
        System.out.println("Attempting to book seat "+s+" "+row+" "+col+" for Flight "+fl+".");
        Airline al = searchAirlines(air);
        if (al!=null){
            Flight flight = al.findFlightByID(fl);
            if (flight!=null){
                FlightSection fs = flight.findFS(flight.getID(), s);
                if (fs!=null && fs.hasAvailableSeats()){
                    Seat seat = fs.findSeat(row, col);
                    if (seat!=null && fs.isSeatAvailable(row, col)){
                        seat.bookSeat();
                        System.out.println("Booked "+fs.getName()+" Seat "+seat.toString()+" on "+ flight.getInfo()+".\n");
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

    public void displaySystemDetails() {
        System.out.println("Displaying System details.");
        System.out.println("System contains "+airlines.size()+" airlines:");
        for(Airline al:airlines) {
            System.out.println("Airline "+al.getName());
            if(!al.getFlightList().isEmpty()) {
                System.out.println(al.getName()+ " associated flights: ");
                for(Flight flight:al.getFlightList()) {
                    System.out.println("-"+flight.getInfo());
                    for(FlightSection fs: flight.getFlightSections()) {
                        System.out.println("---Flight section with "+fs.getRows()+" rows and "+fs.getCols()+" columns.");
                        System.out.print("-----");
                        int booked=0;
                        for(Seat s:fs.getSectionSeats()) {
                            if(s.isBooked()) {
                                booked++;
                            }
                        }
                        int seats = fs.getCols()*fs.getRows();
                        int available = seats-booked;
                        System.out.println(seats+" seats, "+booked+" booked and "+available+" avaiable.");
                    }
                }
            }
        }
        System.out.println("System contains "+airports.size()+" airports:");
        for(Airport ap:airports) {
            System.out.println("Airport "+ap.getName());
        }
        System.out.println();
    }
}
