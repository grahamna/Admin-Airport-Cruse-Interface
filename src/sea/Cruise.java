package sea;

import abs.*;

import java.util.ArrayList;

public class Cruise extends Company{

    public Cruise(String alnName) {
        super("Cruise",alnName);
    }

    public ArrayList getShipList(){
        return getMethodList();
    }

    public void addShip(Ship fl) {
        addMethod(fl);
    }

	public Ship findShipByID(String shipID) {
		return (Ship) findMethodByID(shipID);
    }
    
    public void shipPathFinder(Seaport from, Seaport to) {
        methodPathFinder(from, to);
    }

    @Override
    public String toString(){
        String res = super.toString()+"[";
        for (TransportMethod sp : getMethodList()) {
            res = res +((Ship)sp).toString();
        }
        res = res+"], ";
        return res;
    }
}
