package abs;

public abstract class MyObject{
    private String name;
    private String type;

    MyObject(String type, String name){
        this.name=name;
        this.type=type;
    }

    String getType() { 
        return this.type; 
    }

    String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}