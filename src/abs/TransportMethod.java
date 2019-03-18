package abs;

import java.util.HashSet;

import local.Date;
import local.SeatClass;

public abstract class TransportMethod extends MyObject{
    private Port dest, orig;
    private Date date;

    public TransportMethod(String type, String ID, Port origin, Port destination, Date d) {
        super(ID, type);
        orig=origin;
        dest=destination;
        date=d;
    }
    
    public Port getDest(){
        return dest;
    }
    public Port getOrig(){
        return orig;
    }
    public String getID(){
        return this.getID();
    }
    public Date getDate(){
        return date;
    }

    public HashSet<TransportSection> getSectionList(HashSet<TransportSection> sectionList){
        return sectionList;
    }

    public void addTS(TransportSection ts, SeatClass sc, HashSet<TransportSection> list){
        if (ts==null){
            System.out.println(getType()+"Section doesn't exist.");
        }
        else if(findSection(this, sc, list)!=null){
            System.out.println(getType()+"Section with SeatClass "+sc.toString()+" already exists");
        }
        else{
            list.add(ts);
        }
    }
    public TransportSection findSection(TransportMethod tm, SeatClass sc, HashSet<TransportSection> list) {
        for(TransportSection ts : list){
            if(ts.getSeatClass().equals(sc)){
                return ts;
            }
        }
        return null;
    }

}