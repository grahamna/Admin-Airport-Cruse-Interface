package abs;

import java.util.ArrayList;

public abstract class Company {
    private ArrayList<TransportMethod> methodList;
    private String name;
    private String type;

    public Company(String type, String name){
        this.name=name;
        this.type=type;
        this.methodList=new ArrayList<TransportMethod>();
    }

    public ArrayList<TransportMethod> getMethodList() {
        return this.methodList;
    }

    public void addMethod(TransportMethod tm){
        if (tm==null){
            System.out.println(tm.getType()+" doesn't exist");
        }
        else {
            if (findMethodByID(tm.getID())!=null){
                System.out.println(tm.getType()+" "+tm.getID()+" already exists.");
            }
            else{
                methodList.add(tm);
            }
        }
    }

    public TransportMethod findMethodByID(String id) {
        for(TransportMethod tm : getMethodList()){
            if (tm.getID().equals(id)){
                return tm;
            }
        }
        return null;
    }

    public void methodPathFinder(Port from, Port to){
        for(TransportMethod tm : getMethodList()){
            if(tm.getOrig().equals(from)&&tm.getDest().equals(to)){
                System.out.println("Found matching "+tm.getType()+":\n"+tm.toString()+".");
            }
        }
    }

    String getType(){
        return this.type;
    }
}