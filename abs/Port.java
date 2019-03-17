package abs;

import java.util.HashSet;

public abstract class Port extends MyObject{
    public Port(String n, String t) {
        super(n, t);
    }

    public Port searchPorts(String n, HashSet<Port> ports) {
        for(Port port: ports){
            if(port.toString().equals(n)) {
                return port;
            }
        }
        return null;
    }

}

