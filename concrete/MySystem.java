package concrete;

public abstract class MySystem {

    private String name;
    MySystem(){}
    MySystem(String n) {
        name=n;
    }

    public String getName(){
         return name;
     }

     public abstract String info();
}
