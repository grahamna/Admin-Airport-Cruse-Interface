package abs;

public abstract class Container extends MyObject{
    protected boolean booked;

    public Container(String type) {
        super(type, "");
        booked=false;
    }

    public void bookContainer(){
        booked=true;
    }
    public boolean isBooked(){
        return booked;
    }

    @Override
    public String toString(){
        return "Container";
    }
}