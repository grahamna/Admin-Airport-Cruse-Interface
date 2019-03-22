package UI;

import SystemManager.AirSystemManager;

public class AirlineAdmin extends AdminUI{
    public AirlineAdmin() {
        setType("an Airport", "Airport", "Airport", "Airline", "Flight", "FlightSection", "FlightSeat", new AirSystemManager());
    }
}
