package UI;

import SystemManager.*;
import local.SeatClass;

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
                break;
            
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
        if (sm instanceof airSystemManager){
            ((airSystemManager)sm).displaySystemDetails(System.out);
        }
        else if(sm instanceof seaSystemManager){
            ((seaSystemManager)sm).displaySystemDetails(System.out);
        }
        else{

        }
    }

    private void storeInfo() {
        if (sm instanceof airSystemManager){
            ((airSystemManager)sm).displaySystemDetails();
        }
        else if(sm instanceof seaSystemManager){
            ((seaSystemManager)sm).displaySystemDetails();
        }
        else{

        }
    }

    private void addPort(){
        try {
            System.out.println("Enter Name for "+this.port+": ");
            String res = in.nextLine().toUpperCase();
            if (sm instanceof airSystemManager){
                ((airSystemManager)sm).createAirport(res);
            }
            else if(sm instanceof seaSystemManager){
                ((seaSystemManager)sm).createNewPort(res);
            }
            else{
                
            }
        } catch (Exception e) {
            System.out.println("Unexpected input error");
        }
    }
    private void addCompany(){
        try {
            
            System.out.println("Enter Name for "+this.company+": ");
            String res = in.nextLine().toUpperCase();
            if (sm instanceof airSystemManager){
                ((airSystemManager)sm).createAirline(res);
            }
            else if(sm instanceof seaSystemManager){
                ((seaSystemManager)sm).createCruse(res);
            }
            else{
                
            }
        } catch (Exception e) {
            System.out.println("Unexpected input error");
        }
    }
    private void addTransportMethod(){
        displayDetails();
        try {
            System.out.println("Enter "+this.company+" name: ");
            String ap = in.nextLine().toUpperCase();
            System.out.println("Enter ID for "+this.transportMethod+": ");
            String id = in.nextLine().toUpperCase();
            System.out.println("Origin ID: ");
            String from = in.nextLine().toUpperCase();
            System.out.println("Dest ID: ");
            String to = in.nextLine().toUpperCase();
            System.out.println("Date - Year: ");
            int year = Integer.parseInt(in.nextLine());
            System.out.println("Date - Month: ");
            int month = Integer.parseInt(in.nextLine());
            System.out.println("Date - Day: ");
            int day = Integer.parseInt(in.nextLine());
            System.out.println("Date - Hour: ");
            int hour = Integer.parseInt(in.nextLine());
            System.out.println("Date - Min: ");
            int min = Integer.parseInt(in.nextLine());
            if (sm instanceof airSystemManager){
                ((airSystemManager)sm).createFlight(ap,from,to,year,month,day,hour,min,id);
            }
            else if(sm instanceof seaSystemManager){
                ((seaSystemManager)sm).createShip(ap, from, to, year, month, day, hour, min, id);
            }
            else{
                
            }
            } catch (Exception e) {
                System.out.println("Unexpected input error");
            }
    }
    private void addTransportSection(){
        displayDetails();
        try {
            System.out.println("Enter "+this.company+" name: ");
            String alName = in.nextLine().toUpperCase();
            System.out.println("Enter ID for "+this.transportMethod+": ");
            String flID = in.nextLine().toUpperCase();
            System.out.println("Rows #: ");
            int rows =Integer.parseInt(in.nextLine());
            System.out.println("Layout char (s, m, w): ");
            char layout = in.nextLine().toUpperCase().charAt(0);
            System.out.println("SeatClass char (f, b, e): ");
            char sc = in.nextLine().toUpperCase().charAt(0);
            SeatClass s;
            if (sc=='B'){
                s=SeatClass.business;
            }
            else if(sc=='E'){
                s=SeatClass.economy;
            }
            else if (sc=='F'){
                s=SeatClass.first;
            }
            else{
                throw new IllegalArgumentException("seatclass");
            }
            System.out.println("Cost of "+this.transportSection+": ");
            double cost = Double.parseDouble(in.nextLine());
            if (sm instanceof airSystemManager){
                ((airSystemManager)sm).createSection(alName, flID, rows, layout, s, cost);
            }
            else if (sm instanceof seaSystemManager){
                ((seaSystemManager)sm).createSection(alName, flID, rows, layout, s, cost);
            }
            else{
                
            }
            } catch (Exception e) {
                System.out.println("Unexpected input error");
            }
    }
}
