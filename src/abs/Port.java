package abs;

public abstract class Port{
    private String name;
    private String type;

    public Port(String type,String n){
        this.name=n;
        this.type=type;
    }
    
    String getType(){
        return this.type;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

