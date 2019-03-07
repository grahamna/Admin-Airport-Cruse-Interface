package concrete;

public class Seat{
    int row;
	int col;
    boolean booked;

    public Seat(int row, int col){
        this.row=row;
        this.col=col;
        this.booked=false;
    }
}