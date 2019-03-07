package concrete;

public class Date{
    public int day, year, month;

    public Date(int month, int day, int year) {
        assert month<13&&month>0:"Obj Date month peram error";
        assert year>2018:"Obj Date year peram error";
        assert day>0&&day<32:"Obj Date day peram error";
        this.day=day;
        this.year=year;
        this.month=month;
    }
}