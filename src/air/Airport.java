package air;

import abs.Port;

import java.util.HashSet;

public class Airport extends Port{

    private HashSet<Port> airports;

    public Airport(String apName){
        super("Airport",apName);
    }

    public Airport searchAirports(String n) {
        Airport ap=(Airport)super.searchPorts(n, airports);
        return ap;
    }

    public void addAirport(Port ap) {
        airports.add(ap);
    }

    public HashSet<Port> getAirports() {
        return airports;
    }
}
