package air;


import abs.TransportMethod;
import local.Date;

public class Flight extends TransportMethod{

    private String description;

    public Flight(String desc, Airport orig, Airport dest, Date date, String id) {
        super("Flight", id, orig, dest, date);
        this.description=desc;
        
    }


	public String getName() {
		return null;
    }
    @Override
    public String toString(){
        return this.description;
    }

}
