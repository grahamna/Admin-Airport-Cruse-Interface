package sea;

import java.util.LinkedList;

import abs.Container;
import abs.TransportSection;
import local.*;

public class CabinSection extends TransportSection {

    private int rows;
    private char layChar;
    private SeaLayout layout;
    private LinkedList<Cabin> list;

    public CabinSection(String name, Ship f, int row, char c, SeatClass sc, double cost) {
        super("CabinSection", name, f, sc, cost);
        rows = row;
        layChar = c;
        layout = new SeaLayout(layChar, rows);
        setSectionCapacity(layout.getList());
    }

    public int getRows() {
        return rows;
    }

    public SeaLayout getLayout() {
        return layout;
    }

    public boolean hasAvailableCabins() {
        return super.hasAvailableContainers();
    }

    public LinkedList<Cabin> getCabins() {
        return list;
    }

    public Cabin findCabin(int row, char col) {
        for (Container s : getSectionCapacity()) {
            Cabin fs = (Cabin) s;
            if(fs.getCol()==col && fs.getRow()==row){
                return fs;
            }
        }
        return null;
    }

    public boolean isCabinAvailable(int row, char col){
        Cabin fs = findCabin(row, col);
        if(fs==null){
            System.out.println("No Cabin found matching request.");
            return false;
        }
        else{
            return (!(fs.isBooked()));
        }
    }

    @Override
    public String toString(){
        return "["+super.toString()+ this.layChar+":"+ this.rows+"], ";
    }

}
