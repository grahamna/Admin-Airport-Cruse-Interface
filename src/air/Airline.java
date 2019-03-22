package air;

import abs.*;

import java.util.ArrayList;

public class Airline extends Company{

    public Airline(String alnName) {
        super("Airline",alnName);
    }

    public ArrayList getFlightList(){
        return getMethodList();
    }

    public void addFlight(Flight fl) {
        addMethod(fl);
    }

	public Flight findFlightByID(String flID) {
		return (Flight) findMethodByID(flID);
    }
    
    public Flight flightPathFinder(Airport from, Airport to) {
        return (Flight) methodPathFinder(from, to);
    }

    @Override
    public String toString(){
        String res = super.toString()+"[";
        for (TransportMethod fl : getMethodList()) {
            res = res +((Flight)fl).toString();
        }
        res = res+"], ";
        return res;
    }
}
