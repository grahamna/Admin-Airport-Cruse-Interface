package abs;

public abstract class MyObject{
    private String type;

    MyObject(String t){
        this.type=t;
    }

    String getType() {
        return this.type;
    }
}