package UI;

import SystemManager.SeaSystemManager;

public class CruiseAdmin extends AdminUI{
    public CruiseAdmin() {
        setType("Cruise", "SeaPort", "Cruiseline", "Cruise", "CruiseSection", "Cabin", new SeaSystemManager());
    }

}
