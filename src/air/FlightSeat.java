package air;

import abs.Container;

public class FlightSeat extends Container {
    private int row;
	private char col;
    private boolean aisle, window;

    public FlightSeat(int r, char c, boolean a, boolean w){
        super("FlightSeat");
        row=r;
        col=c;
        aisle=a;
        window=w;
    }

    public int getRow(){
        return row;
    }
    public char getCol(){
        return col;
    }
    public boolean isAsile() {
        return aisle;
    }
    public boolean isWindow() {
        return window;
    }

    @Override
    public String toString(){
        return "Row: "+row+" Col: "+col;
    }
}