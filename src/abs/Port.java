package abs;

public abstract class Port{
    private String name;

    public Port(String n){
        this.name=n;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}

