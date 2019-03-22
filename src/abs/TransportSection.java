package abs;

import java.util.LinkedList;
import local.*;

public abstract class TransportSection extends MyObject{
    protected LinkedList<Container> sectionCapasity;
    private SeatClass s;
    private double cost;
    private TransportMethod tm;

    protected TransportSection(String type, String id, TransportMethod m, SeatClass sc, double c) {
        super(type, id);
        tm = m;
        cost = c;
        s=sc;
    }

    protected LinkedList<Container> getSectionCapasity() {
        return this.sectionCapasity;
    }
     SeatClass getSeatClass() {
        return s;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    private TransportMethod getTm() {
        return tm;
    }

    public boolean hasAvailableContainers(){
        for(Container s : getSectionCapasity()){
            if (!(s.isBooked())){
                return true;
            }
        }
        return false;
    }

    public SeatClass getSC() {
        return s;
    }

    public boolean bookAny(){
        if (this.hasAvailableContainers()){
            for(Container s : getSectionCapasity()){
                if (!(s.isBooked())){
                    s.bookContainer();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return this.s+":"+this.cost+":";
    }
}