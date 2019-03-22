package abs;

import java.util.ArrayList;

import local.Date;
import local.SeatClass;

public abstract class TransportMethod extends MyObject{
    private Port dest, orig;
    private Date date;

    ArrayList myList;

    protected TransportMethod(String type, String ID, Port origin, Port destination, Date d) {
        super(type, ID);
        orig=origin;
        dest=destination;
        date=d;
        myList=new ArrayList<TransportSection>();
    }
    
     Port getDest(){
        return dest;
    }
     Port getOrig(){
        return orig;
    }
     String getID(){
        return getName();
    }
     Date getDate(){
        return date;
    }

    protected ArrayList<TransportSection> getSectionList(){
        return this.myList;
    }

    protected void addTS(TransportSection ts, SeatClass sc){
        if (ts==null){
            System.out.println(getType()+"Section doesn't exist.");
        }
        else if(findSection(this, sc)!=null){
            System.out.println(getType()+"Section with SeatClass "+sc.toString()+" already exists");
        }
        else{
            myList.add(ts);
        }
    }
    protected TransportSection findSection(TransportMethod tm, SeatClass sc) {
        for(TransportSection ts : this.getSectionList()){
            if(ts.getSeatClass().equals(sc)){
                return ts;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        String res = getID()+"|"+date.toString()+"|"+orig+"|"+dest;
        return res;
    }
}