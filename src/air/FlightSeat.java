package air;

import abs.Container;

public class FlightSeat extends Container {
    private int row;
	private char col;
    private boolean asile, window;

    public FlightSeat(int r, char c, boolean a, boolean w){
        super("FlightSeat");
        this.row=r;
        this.col=c;
        this.asile=a;
        this.window=w;
    }

    public int getRow(){
        return this.row;
    }
    public char getCol(){
        return this.col;
    }
    public boolean isAsile() {
        return this.asile;
    }
    public boolean isWindow() {
        return this.window;
    }

    @Override
    public String toString(){
        return "Row: "+row+" Col: "+col;
    }
}