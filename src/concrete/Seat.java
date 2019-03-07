package concrete;

public class Seat{
    int row;
	char col;
    boolean booked;

    public Seat(int row, char col){
        this.row=row;
        this.col=col;
        this.booked=false;
    }

    @Override
    public String toString(){
        String str = "Row: "+this.row+" Col: "+this.col+" Booked: "+this.booked;
        return str;
    }
}