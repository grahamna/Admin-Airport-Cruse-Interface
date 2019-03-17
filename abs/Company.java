package abs;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Company extends MyObject{
    private ArrayList<TransportMethod> methodList;

    public Company(String n, String t){
        super(n, t);
        methodList= new ArrayList<>();
    }

    public ArrayList<TransportMethod> getMethodList() {
        methodList.trimToSize();
        return methodList;
    }

    public void addMethod(TransportMethod tm){
        if (tm==null){
            System.out.println("Object doesn't exist");
        }
        else {
            if (findMethodByID(tm.getID())!=null){
                System.out.println(tm.toString()+" "+tm.getID()+" already exists.");
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

    public Company searchCompanies(String n, HashSet<Company> companies) {
        for(Company comp: companies){
            if(comp.toString().equals(n)) {
                return comp;
            }
        }
        return null;
    }

}