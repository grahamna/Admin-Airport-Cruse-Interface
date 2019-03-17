package abs;

import java.util.LinkedList;
import local.*;

public abstract class TransportSection extends MyObject{
    protected LinkedList<Container> sectionCapasity;
    private SeatClass s;
    private double cost;
    private TransportMethod tm;

    public TransportSection(String name, String type, TransportMethod m, SeatClass sc, double c) {
        super(name, type);
        tm = m;
        cost = c;
        s=sc;
    }

    public LinkedList<Container> getSectionCapasity() {
        return this.sectionCapasity;
    }
    public SeatClass getSeatClass() {
        return s;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public TransportMethod getTm() {
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

    @Override
    public String toString(){
        return "Transport section";
    }
}