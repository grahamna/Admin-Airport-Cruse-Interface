package concrete;

public class Airline extends MySystem{
    private MySystem sd;

    public Airline(String n) {
        super(n);
    }

    public Airline(String n, MySystem ms) {
        super(n);
        sd=ms;
    }

    @Override
    public String info() {
        return sd.info() + "\nAirline "+getName();
    }

}
