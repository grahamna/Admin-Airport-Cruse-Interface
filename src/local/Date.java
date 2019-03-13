package local;

public class Date{
    private int day, year, month, hour, min;

    public Date(int m, int d, int y, int h, int min) {
        this.day=d;
        this.year=y;
        this.month=m;
        this.hour=h;
        this.min=min;
    }

    @Override
    public String toString() {
        return month+"/"+day+"/"+year+" at "+hour+":"+min;
    }
}