package air;

import abs.Container;

public class FlightSeat extends Container {
    private int row;
	private char col;
    private boolean asile, window;

    FlightSeat(int r, char c){
        row=r;
        col=c;
        booked=false;
    }

    public int getRow(){
        return this.row;
    }
    public char getCol(){
        return this.col;
    }

    public void bookSeat(){
        booked=true;
    }

    @Override
    public String toString(){
        return "Row: "+row+" Col: "+col;
    }

    public boolean isBooked() {
        return booked;
    }

}