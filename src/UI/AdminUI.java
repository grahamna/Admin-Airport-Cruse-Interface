package UI;

import SystemManager.*;
import local.SeatClass;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class AdminUI {

    private Scanner in=new Scanner(System.in);
    private SystemManager sm;
    private PrintStream out;
    private String type, port, company, transportMethod, transportSection, container;

    void setType(String t, String p, String cm, String tm, String ts, String cn, SystemManager s) {
        type = t;
        port = p;
        company = cm;
        transportMethod = tm;
        transportSection = ts;
        container = cn;
        sm = s;
    }

    public void Interface() {
        int selection = -1;
        while(selection!=0) {
            System.out.println("\n"+
                    type+" Department\n"+
                    "1. Create a "+type+" system from file.\n"+
                    "2. Change the price associated with a "+container+".\n" +
                    "3. Query the system for "+transportMethod+"s with available "+container+"s.\n"+
                    "4. Change a "+company+" "+container+" pricing.\n"+
                    "5. Book a "+container+".\n"+
                    "6. Book a "+container+" with seating preference.\n"+
                    "7. Display system details.\n"+
                    "8. Store system information in a file.\n"+
                    "9. Add a new "+port+".\n"+
                    "10. Add a new "+company+".\n"+
                    "11. Add a new "+transportMethod+" for a chosen "+company+".\n"+
                    "12. Add a new "+transportSection+" for a chosen "+transportMethod+".\n"+
                    "0. Exit.\n");
                selection=numSelection(in);
                handleSelection(selection);
        }
        System.exit(0);
    }

    public int numSelection(Scanner in) {
        boolean badNumber;
        int selection=-1;
        do {
            try {
                selection=in.nextInt();
                badNumber=false;
                in.nextLine();
            } catch (Exception e) {
                System.out.println("Please enter a number.");
                in.next();
                badNumber=true;
            }
        } while (badNumber);
        return selection;
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

    }

    private void findFlights() {

    }

    private void changeSeatClassPrice() {

    }

    private void bookSeat() {

    }

    private void bookSeatSeatingPref() {

    }

    private void displayDetails() {
        sm.displaySystemDetails(out);
    }

    private void storeInfo() {

    }

    private void addPort(){
        try {
            System.out.println("Enter new "+port+" name: ");
            String res = in.nextLine().toUpperCase();
            if (sm instanceof AirSystemManager){
                ((AirSystemManager)sm).createAirport(res);
            }
            else if(sm instanceof SeaSystemManager){
                ((SeaSystemManager)sm).createNewPort(res);
            }
            else{
                
            }
        } catch (Exception e) {
            System.out.println("Unexpected input error.");
        }
    }
    private void addCompany(){
        try {
            System.out.println("Enter new "+company+" name: ");
            String res = in.nextLine().toUpperCase();
            if (sm instanceof AirSystemManager){
                ((AirSystemManager)sm).createAirline(res);
            }
            else if(sm instanceof SeaSystemManager){
                ((SeaSystemManager)sm).createCruise(res);
            }
            else{
                
            }
        } catch (Exception e) {
            System.out.println("Unexpected input error.");
        }
    }
    private void addTransportMethod(){
        try {
            System.out.println("Enter new "+transportMethod+" name: ");
            String ap = in.nextLine().toUpperCase();
            System.out.println("Enter ID for "+transportMethod+": ");
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
            if (sm instanceof AirSystemManager){
                ((AirSystemManager)sm).createFlight(ap,from,to,year,month,day,hour,min,id);
            }
            else if(sm instanceof SeaSystemManager){
                ((SeaSystemManager)sm).createShip(ap, from, to, year, month, day, hour, min, id);
            }
            else{
                
            }
            } catch (Exception e) {
                System.out.println("Unexpected input error.");
            }
    }
    private void addTransportSection(){
        try {
            System.out.println("Enter "+company+" name: ");
            String alName = in.nextLine().toUpperCase();
            System.out.println("Enter ID for "+transportMethod+": ");
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
            System.out.println("Cost of "+transportSection+": ");
            double cost = Double.parseDouble(in.nextLine());
            if (sm instanceof AirSystemManager){
                ((AirSystemManager)sm).createSection(alName, flID, rows, layout, s, cost);
            }
            else if (sm instanceof SeaSystemManager){
                ((SeaSystemManager)sm).createSection(alName, flID, rows, layout, s, cost);
            }
            else{
                
            }
            } catch (Exception e) {
                System.out.println("Unexpected input error");
            }
    }
}
