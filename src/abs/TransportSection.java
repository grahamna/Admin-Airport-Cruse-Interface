package abs;

import java.util.LinkedList;
import local.*;

public abstract class TransportSection extends MyObject{
    private LinkedList<Container> sectionCapacity;
    private SeatClass s;
    private double cost;
    private TransportMethod tm;

    protected TransportSection(String type, String id, TransportMethod m, SeatClass sc, double c) {
        super(type, id);
        tm=m;
        cost=c;
        s=sc;
    }

    public LinkedList<Container> getSectionCapacity() {
        return sectionCapacity;
    }
    public void setSectionCapacity(LinkedList<Container> list) {
        sectionCapacity=list;
    }
     SeatClass getSeatClass() {
        return s;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double c) {
        cost = c;
    }
    private TransportMethod getTm() {
        return tm;
    }

    public boolean hasAvailableContainers(){
        for(Container s : getSectionCapacity()){
            if (!(s.isBooked())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return s+":"+cost+":";
    }
}