package abs;

public abstract class MyObject{
    private String name;
    private String type;

    public MyObject(String type, String name){
        this.name=name;
        this.type=type;
    }

    public String getType() { 
        return this.type; 
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}