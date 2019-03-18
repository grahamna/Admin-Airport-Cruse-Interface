package air;

import abs.Company;

import java.util.ArrayList;

public class Airline extends Company{

    private ArrayList<Company> airlines;

    public Airline(String alnName) {
        super("Airline",alnName);
    }

	public Flight findFlightByID(String flID) {
		return null;
	}
}
