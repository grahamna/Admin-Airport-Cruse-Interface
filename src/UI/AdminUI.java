package UI;

import SystemManager.SystemManager;
import SystemManager.airSystemManager;
import SystemManager.seaSystemManager;

import java.io.File;
import java.util.Scanner;

public class AdminUI {

    private Scanner in=new Scanner(System.in);
    private int selection=-1;
    private SystemManager sm;
    private String type, port, company, transportMethod, transportSection, container;

    public void setType() {
        while(true){
        try {
                System.out.println("Select Department (1 or 2)\n1: Airport Admin\n2: Cruse Admin\n");
                int res = Integer.parseInt(in.nextLine());
                if (res==1){
                    this.type = "Flight";
                    port = "Airport";
                    company = "Airline";
                    transportMethod = "Flight";
                    transportMethod = "FlightSection";
                    container = "FlightSeat";
                    sm = new airSystemManager();
                }
                if (res==2){
                    this.type="Cruse";
                    port = "SeaPort";
                    company = "Cruseline";
                    transportMethod = "Cruse";
                    transportMethod = "CruseSection";
                    container = "Cabin";
                    sm = new seaSystemManager();
                }
            
        } catch (Exception e) {
            System.out.println("Unexpected input error");
        }
        }
    }

    public void Interface() {
        System.out.println("Welcome to the "+this.type+" Administrator Interface.\nTo begin, please select an option:\n");
        while(selection!=0) {
            System.out.println("\n"+
                    "1. Create a "+this.type +" system from file.\n"+
                    "2. Change the price associated with a "+this.container+".\n" +
                    "3. Query the system for "+this.type+"s with available "+this.container+".\n"+
                    "4. Change the "+this.container+" pricing for a given origin, destination and "+this.company+".\n"+
                    "5. Book a "+this.container+".\n"+
                    "6. Book a "+this.container+" with seating preference.\n"+
                    "7. Display system details.\n"+
                    "8. Store system information in a file.\n"+
                    "9. Add a new "+this.port+".\n"+
                    "10. Add a new "+this.company+".\n"+
                    "11. Add a new "+this.transportMethod+" for a chosen "+this.company+".\n"+
                    "12. Add a new "+this.transportSection+" for a chosen "+this.transportMethod+".\n"+
                    "0. Exit.\n");
            boolean badNumber;
            do{
                try{
                    selection=in.nextInt();
                    badNumber=false;
                    in.nextLine();
                }
                catch(Exception e){
                    System.out.println("Please enter a number.");
                    in.next();
                    badNumber=true;
                }
            } while(badNumber);
            handleSelection(selection);
        }
        System.exit(0);
    }

    private void handleSelection(int num) {
        switch(num) {
            case 0:
                in.close();
                break;
            case 1:
                createAirportFromFile();
                break;
            case 2:
                changeSeatPrice();
                break;
            case 3:
                findFlights();
                break;
            case 4:
                changeSeatClassPrice();
                break;
            case 5:
                bookSeat();
                break;
            case 6:
                bookSeatSeatingPref();
                break;
            case 7:
                displayDetails();
                break;
            case 8:
                storeInfo();
                break;
            case 9:
                addPort();
                break;
            case 10:
                addCompany();
                break;
            case 11:
                addTransportMethod();
                break;
            case 12:
                addTransportSection();
                break;
            default:
                System.out.println("Invalid selection; Please try again.\n");
        }
    }

    private void createAirportFromFile() {
        System.out.println("Please enter a file path to use as input for creating the airport system.\nTo go back to the selection menu, enter 'X'.");
        boolean completed=false;
        while(!completed) {
            String input=in.nextLine();
            if(input.equalsIgnoreCase("X")) {
                System.out.println();
                break;
            }
            else{
                File file=new File(input);
                if(file.exists()) {
                    //createAirportSystem
                    completed=true;
                }
                else {
                    System.out.println("Invalid file path; Please try again.");
                }
            }
        }

    }

    private void changeSeatPrice() {
        displayDetails();
        System.out.println("Which Airline do you wish to change?");
    }

    private void findFlights() {
        System.out.println("Please enter the originating airport name (three characters).\nTo go back to the selection menu, enter 'X'.");
        boolean completed=false;
        while(!completed) {
            String input=in.nextLine();
            if(input.equalsIgnoreCase("X")) {
                System.out.println();
                break;
            }
            else if(input.length()!=3) {
                System.out.println("Airport name must be three characters long.");
            }
            else {

            }

        }
    }

    private void changeSeatClassPrice() {

    }

    private void bookSeat() {

    }

    private void bookSeatSeatingPref() {

    }

    private void displayDetails() {
        sm.displaySystemDetails(System.out);
    }

    private void storeInfo() {
        sm.displaySystemDetails(FILESTREAM);
    }

    private void addPort(){
        System.out.println("Enter Name for "+this.port+": ");
        String res = in.nextLine().toUpperCase();
        if (sm instanceof airSystemManager){
            ((airSystemManager)sm).createAirport(res);
        }
        else if(sm instanceof seaSystemManager){

        }
        else{

        }
    }
    private void addCompany(){
        System.out.println("Enter Name for "+this.company+": ");
        String res = in.nextLine().toUpperCase();
        if (sm instanceof airSystemManager){
            ((airSystemManager)sm).createAirline(res);
        }
        else if(sm instanceof seaSystemManager){

        }
        else{

        }
    }
    private void addTransportMethod(){
        
    }
    private void addTransportSection(){

    }
}
