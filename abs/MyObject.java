package abs;

public abstract class MyObject{
    private String name;
    private String type;

    public MyObject(String n, String t){
        name=n;
        type=t;
    }

    public String getType() { return type; }

    @Override
    public String toString() {
        return name;
    }
}