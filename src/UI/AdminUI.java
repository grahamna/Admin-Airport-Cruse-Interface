package UI;

import SystemManager.SystemManager;

import java.io.File;
import java.util.Scanner;

public class AdminUI extends UI{

    private Scanner in=new Scanner(System.in);
    private int selection=-1;
    private SystemManager sm=new SystemManager();

    public void Interface() {
        System.out.println("Welcome to the Flight Administrator Interface.\nTo begin, please select an option:\n");
        while(selection!=0) {
            System.out.println("1. Create an airport system.\n2. Change the price associated with seats.\n" +
                    "3. Query the system for flights with available seats.\n4. Change the seat class pricing for a given airline." +
                    "\n5. Book a seat.\n6. Book a seat with seating preference.\n7. Display system details.\n8. Store system information in a file.\n" +
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
                break;
            case 1:
                createAirport();
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
            default:
                System.out.println("Invalid selection; Please try again.\n");
        }
    }

    private void createAirport() {
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
        //TODO ask user to specify flight section, check if it exists, then ask for new price
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

}
