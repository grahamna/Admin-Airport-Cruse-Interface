import java.util.ArrayList;

class SystemManager {
    private ArrayList<Airport> airports = new ArrayList<>();
    private ArrayList<Airline> airlines = new ArrayList<>();

    void createAirport(String n) {
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
            }
        }
    }

    void createAirline(String n) {
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
            }
        }
    }

    Airline searchAirlines(String n) {
        for(Airline al: airlines) {
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

    void createFlight(String aname, String orig, String dest, int year, int month, int day, String id) {
        Airline al = searchAirlines(aname);
        if(orig.equals(dest)) {
            System.out.println("Originating airport ("+orig+") cannot be the same as the destination airport.");
        }
        else {
            Airport origin = searchAirports(orig);
            Airport destination = searchAirports(dest);
            if(origin != null && destination != null) {
                Flight flight = new Flight(origin, destination, id);
                System.out.println("Created flight "+id+" from "+orig+" to "+dest+".");
            }
            else {
                System.out.println("Airports "+orig+" and/or "+dest+" don't exist.");
            }
        }
    }

    void createSection(String air, String flID, int rows, int cols, SeatClass s) {

    }

    void findAvailableFlights(String orig, String dest) {

    }

    void bookSeat(String air, String fl, SeatClass s, int row, char col) {

    }

    void displaySystemDetails() {

    }
}
