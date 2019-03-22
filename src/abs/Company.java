package abs;

import java.util.ArrayList;


public abstract class Company extends MyObject{

    private ArrayList methodList;

    protected Company(String type, String name){
        super(type, name);
        methodList= new ArrayList<TransportMethod>();
    }

    protected ArrayList<TransportMethod> getMethodList() {
        methodList.trimToSize();
        return methodList;
    }

    protected void addMethod(TransportMethod tm){
        if (tm==null){
            System.out.println("Object doesn't exist");
        }
        else {
            if (findMethodByID(tm.getID())!=null){
                System.out.println(tm+" "+tm.getID()+" already exists.");
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

    public TransportMethod methodPathFinder(Port from, Port to){
        for(TransportMethod tm : getMethodList()){
            if(tm.getOrig().equals(from)&&tm.getDest().equals(to)){
                System.out.println("Found matching "+tm.getType()+":\n"+tm+".");
                return tm;
            }
        }
        return null;
    }

    public Company searchCompanies(Company c, ArrayList<Company> companies) {
        for(Company comp: companies){
            if(comp.getName().equals(c.getName())&&comp.getType().equals(c.getType())) {
                return comp;
            }
        }
        return null;
    }

    public static Company searchCompanies(String c, ArrayList<Company> companies) {
        for(Company comp: companies){
            if(comp.getName().equals(c)) {
                return comp;
            }
        }
        return null;
    }

}