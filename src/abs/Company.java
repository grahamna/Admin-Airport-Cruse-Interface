package abs;

import java.util.ArrayList;

public abstract class Company {
    private ArrayList<TransportMethod> methodList;
    private String name;

    public Company(String name){
        this.name=name;
        this.methodList=new ArrayList<TransportMethod>();
    }

    public void listAdd(TransportMethod tm) {
        methodList.add(tm);
    }

    public ArrayList<TransportMethod> getMethodList() {
        return this.methodList;
    }

    public TransportMethod findMethodByID(String id) {
        for(TransportMethod tm : getMethodList()){
            if (tm.getID().equals(id)){
                return tm;
            }
        }
        return null;
    }
}