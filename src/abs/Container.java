package abs;

public abstract class Container extends MyObject{
    protected boolean booked;

    public Container(String type) {
        super(type);
        this.booked=false;
    }

    public void bookContainer(){
        this.booked=true;
    }
    public boolean isBooked(){
        return this.booked;
    }
}