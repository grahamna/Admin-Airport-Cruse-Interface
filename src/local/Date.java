package local;

public class Date{
    private int day, year, month, hour, minute;

    public Date(int m, int d, int y, int h, int min) {
        day=d;
        year=y;
        month=m;
        hour=h;
        minute=min;
    }

    @Override
    public String toString() {
        return year+", "+month+", "+day+", "+hour+", "+minute;
    }
}