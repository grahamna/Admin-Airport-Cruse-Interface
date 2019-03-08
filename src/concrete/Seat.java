package concrete;

public class Seat{
    int row;
	char col;
    public boolean booked;

    Seat(int r, char c){
        row=r;
        col=c;
        booked=false;
    }

    public void bookSeat(){
        booked=true;
    }

    @Override
    public String toString(){
        return "Row: "+row+" Col: "+col;
    }
}