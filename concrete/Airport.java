package concrete;

public class Airport extends MySystem {
    private MySystem sd;

    public Airport(String n){
        super(n);
    }


    public Airport(String n, MySystem ms) {
        super(n);
        sd=ms;
    }

    @Override
    public String info() {
        return sd.info() + "\nAirport "+getName();
    }


}
