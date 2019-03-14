package air;

import java.util.LinkedList;

import abs.Container;
import abs.TransportSection;
import local.*;

public class FlightSection extends TransportSection {

    private int rows;
    private Layout layout;
    private String description;
    private LinkedList<FlightSeat> myList;

    public FlightSection(String desc, Flight f, int row, char c, SeatClass sc, double cost) {
        super("FlightSection", f, sc, cost);
        this.rows = row;
        this.layout = new Layout(c, this.rows);
        this.sectionCapasity = this.layout.getList();
        this.description = desc;
    }

    public int getRows() {
        return this.rows;
    }
    public Layout getLayout() {
        return this.layout;
    }

    public boolean hasAvalableFlightSeats() {
        return super.hasAvailableContainers();
    }

    public FlightSeat findFlightSeat(int row, char col) {
        for (Container s : this.getSectionCapasity()) {
            FlightSeat fs = (FlightSeat) s;
            if(fs.getCol()==col && fs.getRow()==row){
                return fs;
            }
        }
        return null;
    }

    public boolean isSeatAvailable(int row, char col){
        FlightSeat fs = findFlightSeat(row, col);
        if(fs==null){
            System.out.println("No seat found matching request.");
            return false;
        }
        else{
            return (!(fs.isBooked()));
        }
    }

}
