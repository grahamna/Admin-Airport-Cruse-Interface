package air;

import java.util.ArrayList;

import abs.TransportSection;
import local.*;

public class FlightSection extends TransportSection{

    private int rows;
    private char layout;
    private String description;

    public FlightSection(String desc, Flight f, int row, char layout, SeatClass sc,double cost){
        super("FlightSection",f,sc,cost);
        this.rows=row;
        this.description=desc;
        createSeatArray(row, layout);
    }

    public int getRows() {
        return rows;
    }

    private void createFlightSeatArray(int row, char layout){
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
                    System.out.println("Seat "+temp.toString()+" has been added.");
                }
                else{
                    System.out.println("Seat was found to be invalid.");
                }
            }
        }
    }

    public Seat findSeat(int row, char col) {
        for (Seat s : this.sectionSeats){
            if(s.getCol()==col && s.getRow()==row){
                return s;
            }
        }
        return null;
    }

    public boolean isSeatAvailable(int row, char col){
        Seat s = findSeat(row, col);
        if(s==null){
            System.out.println("No seat found matching request.");
            return false;
        }
        else{
            return (!(s.isBooked()));
        }
    }


    public HashSet<Seat> getSectionSeats() {
        return sectionSeats;
    }

}
