package concrete;

public class Seat{
    private int row, col;
    private boolean booked;

    public Seat(int row, int col){
        this.row=row;
        this.col=col;
        this.booked=false;
    }
}