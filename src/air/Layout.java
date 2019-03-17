package air;

import java.util.LinkedList;
import abs.Container;


public class Layout{
    private int row;
    private LinkedList<Container> seatList;
    private layoutType lt;

    public Layout(char l, int r) {
        char temp = Character.toUpperCase(l);
        row = r;
        if (temp=='S'){
            lt = new layout_S();
        }
        else if(temp=='M'){
            lt = new layout_M();
        }
        else if(temp=='W'){
            lt = new layout_W();
        }
        else{
            System.out.println("Invalid Layout char");
        }
        createContainerList(row);
    }

    public LinkedList<Container> getList() {
        return seatList;
    }

    abstract class layoutType {
        int col;
        boolean window=false;
        boolean aisle=false;
        abstract Container makeSeat(int row, int col, char c);
    }

    private class layout_S extends layoutType{
        
        private layout_S() {
            this.col=2;
        }

        Container makeSeat(int row, int col, char c){
            if (col==0 || col==2){
                window=true;
            }
            if (col==0 || col==1){
                aisle=true;
            }
            Container fs = new FlightSeat(row,c,aisle,window);
            return fs;
        }
    }    
    private class layout_M extends layoutType {
        private layout_M() {
            col=3;
        }
        
        Container makeSeat(int row, int col, char c){
            if (col==0 || col==3){
                window=true;
            }
            if (col==1 || col==2){
                aisle=true;
            }
            Container fs = new FlightSeat(row,c,aisle,window);
            return fs;
        }
    }
    private class layout_W extends layoutType{
        private layout_W() {
            col=9;
        }
        Container makeSeat(int row, int col, char c){
            if (col==0 || col==9){
                window=true;
            }
            if (col==2 || col==3 || col==6 || col==7){
                aisle=true;
            }
            Container fs = new FlightSeat(row,c,aisle,window);
            return fs;
        }
        
    }
    private void createContainerList(int row){
        seatList = new LinkedList<Container>();
        for(int x=0;x<row;x++){
            for(int y=0;y<lt.col;y++){
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
                    Container temp = lt.makeSeat(x,y,c);
                    seatList.add(temp);
                    System.out.println("Seat "+temp.toString()+" has been added.");
                }
                else{
                    System.out.println("Seat was found to be invalid.");
                }
            }
        }
    }
    
}