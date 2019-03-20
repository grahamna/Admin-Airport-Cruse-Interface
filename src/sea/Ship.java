package sea;

import abs.TransportMethod;
import abs.TransportSection;
import local.*;

public class Ship extends TransportMethod{


    public Ship(Seaport orig, Seaport dest, Date date, String id) {
        super("Ship", id, orig, dest, date);
        
    }

    public CabinSection findCS(Ship flight, SeatClass s) {
        CabinSection fs=(CabinSection) findSection(flight, s);
        return fs;
    }

    public void addCabinSection(CabinSection fs, SeatClass s) {
        addTS(fs, s);

    }

    @Override
    public String toString(){
        String res = super.toString();
        for (TransportSection cs : getSectionList()) {
            res = res + ((CabinSection)cs).toString();
        }
        return res;
    }

}
