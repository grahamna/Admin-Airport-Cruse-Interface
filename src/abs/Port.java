package abs;

public abstract class Port extends MyObject{
    private String name;

    public Port(String type,String n){
        super(type);
        this.name=n;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

