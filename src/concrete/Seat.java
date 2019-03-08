package concrete;

public class Seat{
    private int row;
	private char col;
    private boolean booked;

    Seat(int r, char c){
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