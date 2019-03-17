package air;

import abs.Company;

import java.util.HashSet;

public class Airline extends Company{

    private HashSet<Company> airlines;

    public Airline(String alnName) {
        super("Airline",alnName);
    }

    public Airline searchAirlines(String n) {
        Airline al=(Airline)super.searchCompanies(n, airlines);
        return al;
    }

    public void addAirline(Airline al) {
        airlines.add(al);
    }

    public HashSet<Company> getAirlines() {
        return airlines;
    }
}
