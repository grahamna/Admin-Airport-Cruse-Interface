package abs;

import java.util.ArrayList;

public abstract class Port extends MyObject{

    public Port(String type, String name) {
        super(type, name);
    }

    public Port searchPorts(Port search, ArrayList<Port> ports) {
        for(Port p: ports){
            if(p.getName().equals(search.getName())&&p.getType().equals(search.getType())) {
                return p;
            }
        }
        return null;
    }
    public static Port searchPorts(String search, ArrayList<Port> ports) {
        for(Port p: ports){
            if(p.getName().equals(search)) {
                return p;
            }
        }
        return null;
    }
}

