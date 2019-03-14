package air;

import java.util.ArrayList;

import abs.TransportMethod;
import local.Date;

public class Flight extends TransportMethod{

    private String description;

    public Flight(String desc, Airport orig, Airport dest, Date date, String id) {
        super("Flight", id, orig, dest, date);
        this.description=desc;
        
    }

    public void addSection(FlightSection fs){
        if(fs==null) {
            System.out.println("Flight section doesn't exist.");
        }
        else {
            flightSections.add(fs);
        }

    }

    public String getInfo() {
        return fo.getInfo();
    }

	public String getName() {
		return null;
    }
    @Override
    public String toString(){
        return this.description;
    }

}
