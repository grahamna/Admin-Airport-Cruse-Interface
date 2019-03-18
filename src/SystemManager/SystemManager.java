package SystemManager;

import air.*;

import java.io.PrintStream;
import java.util.ArrayList;

import abs.*;
import local.*;
import sea.Cruse;
import sea.Seaport;

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

    public void createPort(String name,String type) {
        System.out.println("Attempting to create "+type+" "+name+".");
        int charNumAirport = 3;
        if(name.length() != charNumAirport) {
            System.out.println("Invalid input "+name+": "+type+" name must be 3 characters long.\n");
        }
        else{
            Port port;
            if (this instanceof airSystemManager){
                port = new Airport(name);
            }
            else if (this instanceof seaSystemManager){
                port = new Seaport(name);
            }
            else {
                throw new UnsupportedOperationException("SysMan not identified");
            }
            if(searchPorts(port)!=null){
                System.out.println(type+" "+name+" already exists.\n");
            }
            else{
                addPort(port);
                System.out.println("Created "+type+" "+name+".\n");
            }
        }
    }

    public void createCompany(String name,String type) {
        System.out.println("Attempting to create "+type+" "+name+".");
        int charNumAirline = 5;
        if(name.length() > charNumAirline) {
            System.out.println("Invalid input "+name+": "+type+" name must be less than 6 characters long.\n");
        }
        else {
            Company company;
            if (this instanceof airSystemManager){
                company = new Airline(name);
            }
            else if (this instanceof seaSystemManager){
                company = new Cruse(name);
            }
            else {
                throw new UnsupportedOperationException("SysMan not identified");
            }
            if(searchCompany(company)!=null) {
                System.out.println(type+" "+name+" already exists.\n");
            }
            else{
                searchCompany(company);
                System.out.println("Created "+type+" "+name+".\n");
            }
        }
    }



    
}
