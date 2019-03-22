package abs;

public abstract class MyObject{
    private String name;
    private String type;

    MyObject(String t, String n){
        name=n;
        type=t;
    }

    String getType() { 
        return type;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}