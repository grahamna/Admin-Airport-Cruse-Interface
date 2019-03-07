package concrete;

import java.util.ArrayList;

import seatClass.SeatClass;

public class FlightSection {

    public ArrayList<Seat> sectionSeats = new ArrayList<Seat>();

    public SeatClass s;
    private int rows, cols;
    public Flight flight;

    public FlightSection(Flight f, int row, int col, SeatClass s){
        this.flight=f;
        this.rows=row;
        this.cols=col;
        this.s=s;
        createSeatArray(row, col);
    }

    public boolean hasAvalableSeats(){
        for(Seat s : this.sectionSeats){
            if (!(s.booked)){
                return true;
            }
        }
        return false;
    }

    public void createSeatArray(int row, int col){
        for(int x=0;x<row;x++){
            for(int y=0;y<col;y++){
                char c=' ';
                if (y==0){
                    c='A';
                }
                else if (y==1){
                    c='B';
                }
                else if (y==2){
                    c='C';
                }
                else if (y==3){
                    c='D';
                }
                else if (y==4){
                    c='E';
                }
                else if (y==5){
                    c='F';
                }
                else if (y==6){
                    c='G';
                }
                else if (y==7){
                    c='H';
                }
                else if (y==8){
                    c='I';
                }
                else if (y==9){
                    c='J';
                }
                if (c!=' '){
                    Seat temp = new Seat(x, c);
                    sectionSeats.add(temp);
                    System.out.println("Seat "+temp+" has been added");
                }
                else{
                    System.out.println("Seat was found to be invalid");
                }
            }
        }
    }

    public Seat findSeat(int row, char col) {
        for (Seat s : this.sectionSeats){
            if(s.col==col && s.row==row){
                return s;
            }
        }
        return null;
    }

    public boolean isSeatAvalable(int row, char col){
        Seat s = findSeat(row, col);
        if(s==null){
            System.out.println("no seat found matching request");
            return false;
        }
        else{
            return s.booked;
        }
    }
}
