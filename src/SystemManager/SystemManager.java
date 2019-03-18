package SystemManager;

import air.*;

import java.io.PrintStream;
import java.util.ArrayList;

import abs.*;
import local.*;

public abstract class SystemManager {

    ArrayList<Port> myPorts = new ArrayList<Port>();

    public Port searchPorts(Port search) {
        return search.searchPorts(search, myPorts);
    }
    public Port searchPorts(String search) {
        return Port.searchPorts(search, myPorts);
    }

    public void addPort(Port ap) {
        myPorts.add(ap);
    }

    protected ArrayList<Port> getPorts() {
        return this.myPorts;
    }


    ArrayList<Company> myCompany = new ArrayList<Company>();

    public Company searchCompany(Company search) {
        return search.searchCompanies(search, myCompany);
    }
    public Company searchCompany(String search) {
        return Company.searchCompanies(search, myCompany);
    
    }

    public void addCompany(Company al) {
        myCompany.add(al);
    }

    public ArrayList<Company> getCompanys() {
        return this.myCompany;
    }

    public void createPort(String name) {
        System.out.println("Attempting to create Airport "+name+".");
        int charNumAirport = 3;
        if(name.length() != charNumAirport) {
            System.out.println("Invalid input "+name+": Airport name must be 3 characters long.\n");
        }
    }

    public void createCompany(String name) {
        System.out.println("Attempting to create Airline "+name+".");
        int charNumAirline = 5;
        if(name.length() > charNumAirline) {
            System.out.println("Invalid input "+name+": Airline name must be less than 6 characters long.\n");
        }
    }



    
}
