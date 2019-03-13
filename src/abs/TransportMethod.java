package abs;

import java.util.ArrayList;

import local.Date;

public abstract class TransportMethod {
    private ArrayList<TransportSection> sectionList;
    private String ID;
    private Port dest, orig;
    private Date date;
    private String type;

    public TransportMethod(String type,String n, Port orig, Port dest, Date date) {
        this.ID=n;
        this.orig=orig;
        this.dest=dest;
        this.date=date;
        this.type=type;
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
    String getType(){
        return this.type;
    }
    public TransportSection findSection(Transpo)

    @Override
    public String toString(){
        return null;
    }

}