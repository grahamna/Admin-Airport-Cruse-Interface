package abs;

import java.util.ArrayList;

import local.Date;
import local.SeatClass;

public abstract class TransportMethod extends MyObject{
    private ArrayList<TransportSection> sectionList;
    private String ID;
    private Port dest, orig;
    private Date date;

    public TransportMethod(String type, String n, Port orig, Port dest, Date date) {
        super(type);
        this.ID=n;
        this.orig=orig;
        this.dest=dest;
        this.date=date;
    }
    
    public Port getDest(){
        return this.dest;
    }
    public Port getOrig(){
        return this.orig;
    }
    public String getID(){
        return this.ID;
    }
    public Date getDate(){
        return this.date;
    }
    public ArrayList<TransportSection> getSectionList(){
        return this.sectionList;
    }

    public void addTS(TransportSection ts, SeatClass sc){
        if (ts==null){
            System.out.println(getType()+"Section doesn't exist.");
        }
        else if(findSection(this, sc)!=null){
            System.out.println(getType()+"Section with SeatClass "+sc.toString()+" already exists");
        }
        else{
            this.sectionList.add(ts);
        }
    }
    public TransportSection findSection(TransportMethod tm, SeatClass sc) {
        for(TransportSection ts : tm.getSectionList()){
            if(ts.getSeatClass().equals(sc)){
                return ts;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return null;
    }

}