package concrete;

public abstract class MySystem {

    public String name;
    MySystem(String n) {
        name=n;
    }

    public String getName(){
        return name;
     }
    public abstract String info();
}
