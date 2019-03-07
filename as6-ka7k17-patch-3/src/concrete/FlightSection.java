package concrete;

import java.util.HashSet;

import seatClass.SeatClass;

public class FlightSection {

    public HashSet<Seat> sectionSeats = new HashSet<Seat>();

    private SeatClass s;
    private int rows, cols;
    private Flight flight;
    private Seat[] seats;

    public FlightSection(Flight f, int row, int col, SeatClass s){
        this.flight=f;
        this.rows=row;
        this.cols=col;
        this.s=s;
    }
}
