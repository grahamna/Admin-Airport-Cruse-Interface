package concreteObjects;

import java.util.HashSet;

/*Airline: This class maintains information about airlines.  An airline can have 0 or more flights associated with it.  When created an airline is not associated with any flights.  All flights for a given airline must have unique flight ids.*/

public class Airline {
    private String name; //strlen < 6, unique name
    private HashSet flightList; //Can have 0-n members, initialized to have 0 flights

}
