package UI;

import SystemManager.SeaSystemManager;

public class CruiseAdmin extends AdminUI{
    public CruiseAdmin() {
        setType("a Cruise", "Cruise", "SeaPort", "Cruiseline", "Cruise", "CruiseSection", "Cabin", new SeaSystemManager());
    }

}
