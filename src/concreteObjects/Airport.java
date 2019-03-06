package concreteObjects;

import java.util.HashSet;

/*Airport: Objects of this class represent airports.  The only information maintained is the name, which must be exactly 3 characters in length. */

public class Airport {
    private String name; //char len 3, must be unique
    private HashSet<Airline> airlineList = new HashSet<Airline>();

    public Airport(String name){
        assert name.length()==3:"Airport name.len must be 3";
        this.name=name;
    }



    @Override
    public String toString(){
        String str = "Airport "+this.name;
        return str;
    }
}
