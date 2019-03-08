package concrete;

import java.util.HashSet;

import seatClass.SeatClass;

public class FlightSection extends MySystem{

    private HashSet<Seat> sectionSeats = new HashSet<>();

    private SeatClass s;
    private int rows, cols;
    private Flight flight;
    private double cost;

    public FlightSection(String name, Flight f, int row, int col, SeatClass sc){
        super(name);
        flight=f;
        rows=row;
        cols=col;
        s=sc;
        createSeatArray(row, col);
    }

    public int getRows() {
        return rows;
    }
    public double getCost() {
        return this.cost;
    }
    public int getCols() {
        return cols;
    }
    public SeatClass getS() {
        return s;
    }
    public Flight getFlight() {
        return flight;
    }

    public boolean hasAvailableSeats(){
        for(Seat s : sectionSeats){
            if (!(s.isBooked())){
                return true;
            }
        }
        return false;
    }

    private void createSeatArray(int row, int col){
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
