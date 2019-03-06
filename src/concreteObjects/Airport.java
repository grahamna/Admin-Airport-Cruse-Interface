package concreteObjects;

import java.util.HashSet;

/*Airport: Objects of this class represent airports.  The only information maintained is the name, which must be exactly 3 characters in length. */

public class Airport {
    private String name; //char len 3, must be unique
    private HashSet airlineList;
}
