package air;

import java.util.LinkedList;

import abs.Container;
import abs.TransportSection;
import local.*;

public class FlightSection extends TransportSection {

    private int rows;
    private char layChar;
    private AirLayout layout;
    private LinkedList<FlightSeat> list;

    public FlightSection(String name, Flight f, int row, char c, SeatClass sc, double cost) {
        super("FlightSection", name, f, sc, cost);
        this.rows = row;
        this.layChar = c;
        this.layout = new AirLayout(this.layChar,this.rows);
        this.sectionCapasity = layout.getList();
    }

    public int getRows() {
        return rows;
    }

    public AirLayout getLayout() {
        return layout;
    }

    public boolean hasAvalableFlightSeats() {
        return super.hasAvailableContainers();
    }

    public LinkedList<FlightSeat> getSeats() {
        return list;
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

    @Override
    public String toString(){
        String res = "["+super.toString()+this.layChar+":"+this.rows+"], ";
        return res;
    }

}
