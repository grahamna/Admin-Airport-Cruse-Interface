package abs;

import java.util.ArrayList;

import local.Date;

public abstract class TransportMethod {
    private ArrayList<TransportSection> sectionList;
    private String ID;
    private Port dest, orig;
    private Date date;

    public TransportMethod(String n, Port orig, Port dest, Date date) {
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

}