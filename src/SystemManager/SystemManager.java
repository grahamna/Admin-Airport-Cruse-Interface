package SystemManager;

import flight.SeatClass;

/*SystemManager: This class provides the interface (Façade) to the system.  That is, clients interact with the system by calling operations in the SystemManager.  The SystemManager is linked to all the airport and airline objects in the system.  When it is created, the SystemManager has no airport or airline objects linked to it.  To create airports and airlines, the createAirport() and createAirline() operations defined in this class must be invoked.  The class also contains operations for creating sections of flights (e.g., first class and business class sections), finding available flights between two airports, and booking a seat on a flight.  A printout of information on all the airports, airlines, flights, flight sections and seats is obtained by invoking displaySystemDetails().

createAirport(String n): Creates an airport object and links it to the SystemManager.  The airport will have a name (code) n; n must have exactly three characters.  No two airports can have the same name.

createAirline(String n): Creates an airline object with name n and links it to the SystemManager.  An airline has a name that must have a length less than 6.  No two airlines can have the same name.

createFlight(String aName, String orig, String dest, int year, int month, int day, String id): Creates a flight for an airline named aname, from an originating airport (orig) to a destination airport (dest) on a particular date.  The flight has an identifier (id).

createSection(String air, String flID, int rows, int cols, SeatClass s): Creates a section, of class s, for a flight with identifier flID, associated with an airline, air.  The section will contain the input number of rows and columns.

findAvailableFlights(String orig, String dest): Finds all flights from airport orig to airport dest with seats that are not booked.

bookSeat(String air, String fl, SeatClass s, int row, char col): Books seat in given row and column in section s, on flight fl of airline air.

displaySystemDetails(): Displays attribute values for all objects (e.g., airports, airplanes) in system.   */

public class SystemManager {

	public void createAirport(String name) {
		// TODO Auto-generated method stub
		
	}

	public void createAirline(String name) {
		// TODO Auto-generated method stub
		
	}

	public void createFlight(String name, String orig, String dest, int year, int month, int day, String id) {
		// TODO Auto-generated method stub
		
	}

	public void createSection(String airline, String flightID, int rows, int cols, SeatClass economy) {
		// TODO Auto-generated method stub
		
	}

	public void bookSeat(String airline, String flight, SeatClass first, int row, char col) {
		// TODO Auto-generated method stub
		
	}

	public void displaySystemDetails() {
		// TODO Auto-generated method stub
		
	}

	public void findAvailableFlights(String orig, String dest) {
		// TODO Auto-generated method stub
		
	}

}
