package UI;

import SystemManager.AirSystemManager;

public class AirlineAdmin extends AdminUI{
    public AirlineAdmin() {
        setType("Airport", "Airport", "Airline", "Flight", "FlightSection", "FlightSeat", new AirSystemManager());
    }
}
