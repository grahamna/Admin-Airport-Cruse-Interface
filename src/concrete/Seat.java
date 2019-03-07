package concrete;

public class Seat{
    public int row;
    public char col;
    public boolean booked;

    public Seat(int row, char col){
        this.row=row;
        this.col=col;
        this.booked=false;
    }
}