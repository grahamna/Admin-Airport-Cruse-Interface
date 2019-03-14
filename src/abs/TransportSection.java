package abs;

import java.util.ArrayList;
import local.*;

public abstract class TransportSection extends MyObject{
    private ArrayList<Container> sectionCapasity;
    private SeatClass s;
    private double cost;
    private TransportMethod tm;

    public TransportSection(String type, TransportMethod m, SeatClass sc, double cost) {
        super(type);
        this.tm = m;
        this.cost = cost;
        this.s=sc;
    }

    public ArrayList<Container> getSectionCapasity() {
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

    @Override
    public String toString(){
        return null;
    }
}