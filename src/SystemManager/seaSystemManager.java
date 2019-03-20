package SystemManager;

import sea.*;


import abs.*;
import local.*;

public class seaSystemManager extends SystemManager {
    public Seaport searchSeaports(Seaport search) {
        return (Seaport) searchPorts(search);
    }
    public Seaport searchSeaports(String search) {
        return (Seaport) Port.searchPorts(search, myPorts);
    }

    public void addSeaport(Seaport ap) {
        myPorts.add(ap);
    }

    public Cruse searchCruse(Cruse search) {
        return (Cruse)searchCompany(search);
    }
    public Cruse searchCruse(String search) {
        return (Cruse) Company.searchCompanies(search, myCompany);
    
    }

    public void addCruse(Cruse al) {
        myCompany.add(al);
    }

    public void createNewPort(String name) {
        createPort(name,"Seaport");
    }
    

    public void createCruse(String name) {
        createCompany(name,"Cruse");
    }

    public void createShip(String aname, String orig, String dest, int year, int month, int day, int hour, int min, String id) {
        createTransportMethod(aname, orig, dest, year, month, day, hour, min, id, "Ship");
    }

    public void createSection(String alName, String flID, int rows, char layout, SeatClass s, double cost) {
        createSection(alName, flID, rows, layout, s, cost, "Ship");

    }

    public void findAvailableShips(String orig, String dest) {
        findAvailablePath(orig, dest);
    }

    public void bookSeat(String air, String fl, SeatClass s, int row, char col) {
        bookContainer(air, fl, s, row, col);
    }
}
