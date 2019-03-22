package UI;

import SystemManager.*;
import local.SeatClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class AdminUI {

    private Scanner in=new Scanner(System.in);
    private SystemManager sm;
    private PrintStream out;
    private String name, type, port, company, transportMethod, transportSection, container;

    void setType(String n, String t, String p, String cm, String tm, String ts, String cn, SystemManager s) {
        name = n;
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
                    "1. Create "+name+" system from file.\n"+
                    "2. Change the price associated with a "+container+".\n" +
                    "3. Query the system for "+transportMethod+"s with available "+container+"s.\n"+
                    "4. Change "+container+" pricing.\n"+
                    "5. Book a "+container+".\n"+
                    "6. Book a "+container+" with seating preference.\n"+
                    "7. Display system details.\n"+
                    "8. Store system information in a file.\n"+
                    "9. Add a new "+port+".\n"+
                    "10. Add a new "+company+".\n"+
                    "11. Add a new "+transportMethod+" for a chosen "+company+".\n"+
                    "12. Add a new "+transportSection+" for a chosen "+transportMethod+".\n"+
                    "0. Exit.");
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
                createFromFile();
                break;
            case 2:
                changeSeatPrice();
                break;
            case 3:
                findTrips();
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

    private void createFromFile() {
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
                    try {
                        completed=createFromFile(file);
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found.");
                    }
                }
                else {
                    System.out.println("Invalid file path; Please try again.");
                }
            }
        }

    }

    private boolean createFromFile(File file) throws FileNotFoundException {
        Queue<Character> queue=new LinkedList<>();
        List<String> portlist = new ArrayList<>();
        List<String> companylist = new ArrayList<>();
        List<String> travellist = new ArrayList<>();
        try{
            char[] input = fileToString(file).replaceAll("\\s+", "").toCharArray();
            for(char i : input){
                queue.add(i);
            }
            portlist = buildPortList(queue);
            travellist = buildTravelList(queue);
            for(String f : travellist){
                if(f.length() < 10){
                    String n=f.replaceAll("[^A-Z]","");
                    if(n.length()>0) {
                        companylist.add(n);
                    }
                }
            }
            for(String a : portlist){
                if(sm instanceof AirSystemManager) {
                    ((AirSystemManager) sm).createAirport(a);
                }
                else if(sm instanceof  SeaSystemManager) {
                    ((SeaSystemManager) sm).createNewPort(a);
                }
            }
            for(String a : companylist){
                if(sm instanceof AirSystemManager) {
                    ((AirSystemManager) sm).createAirline(a);
                }
                else if(sm instanceof  SeaSystemManager) {
                    ((SeaSystemManager) sm).createCruise(a);
                }
            }
            String air = "";
            for(String a : travellist){
                if(a.length() < 10){
                    air = a;
                }else{
                    createFlightFromFile(a, air);
                }
            }
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    private String fileToString(File n){
        Scanner input;
        StringBuilder s = new StringBuilder();
        try {
            input = new Scanner(n);
            while(input.hasNext()){
                s.append(input.nextLine());
            }

        } catch (FileNotFoundException e) {
            s = null;
            System.out.println("Error reading file.");
        }
        return s.toString();
    }

    private ArrayList<String> buildPortList(Queue<Character> q){
        ArrayList<String> a = new ArrayList<String>();
        StringBuilder temp = new StringBuilder();
        while(q.peek() != ']'){
            if(q.peek() == '['){
                q.poll();
            }else if(q.peek() == ','){
                q.poll();
                a.add(temp.toString());
                temp = new StringBuilder();
            }else{
                temp.append(q.poll());
            }
            if(q.peek() == ']'){
                a.add(temp.toString());
                temp = new StringBuilder();
            }
        }
        q.poll();
        return a;
    }

    private ArrayList<String> buildTravelList(Queue<Character> q){
        ArrayList<String> a = new ArrayList<String>();
        StringBuilder temp = new StringBuilder();
        while(q.peek() != '}'){
            if(q.peek() == '{'){
                q.poll();
            }
            while(q.peek() != '[' && q.peek() != '}'){
                temp.append(q.poll());
            }
            a.add(temp.toString());
            temp = new StringBuilder();
            while(q.peek() != ']' && q.peek() != '}' && q.peek() != ','){
                if(q.peek() == '['){
                    q.poll();
                }
                while(q.peek() != ']'){
                    temp.append(q.poll());
                }
                temp.append(q.poll());
                q.poll();
                a.add(temp.toString());
                temp = new StringBuilder();
            }
            if(q.peek() == ','){
                q.poll();
            }
        }
        return a;
    }

    private void createFlightFromFile(String f, String a){
        char[] flight = f.toCharArray();
        ArrayList<String> info = new ArrayList<String>();
        ArrayList<String> sec = new ArrayList<String>();
        StringBuilder temp = new StringBuilder();
        boolean readingSeats = false;
        for(char c : flight){
            if(!readingSeats){
                if(c == '['){
                    info.add(temp.toString());
                    temp = new StringBuilder();
                    readingSeats = true;
                }else if(c == '|' || c == ','){
                    info.add(temp.toString());
                    temp = new StringBuilder();
                }else{
                    temp.append(c);
                }
            }else{
                if(c == ']'){
                    sec.add(temp.toString());
                    temp = new StringBuilder();
                }else if(c == ':' || c == ','){
                    sec.add(temp.toString());
                    temp = new StringBuilder();
                }else{
                    temp.append(c);
                }
            }
        }
        String org, dest, id;
        int y, m, d, h, min;
        id = info.get(0);
        org = info.get(6);
        dest = info.get(7);
        y = Integer.parseInt(info.get(1));
        m = Integer.parseInt(info.get(2));
        d = Integer.parseInt(info.get(3));
        h = Integer.parseInt(info.get(4));
        min = Integer.parseInt(info.get(5));

        if(sm instanceof AirSystemManager) {
            ((AirSystemManager) sm).createFlight(a,org,dest,y,m,d,h,min,id);
            SeatClass c=null;
            int r;
            double p;
            ArrayList<Character> list = new ArrayList<>();
            for(int i=0; i<sec.size()/4; i++){
                String ch=sec.get(4*i);
                switch (ch) {
                    case "B":
                        c = SeatClass.business;
                        break;
                    case "F":
                        c = SeatClass.first;
                        break;
                    case "E":
                        c = SeatClass.economy;
                        break;
                    default:
                        System.out.println("Failed to read seat class.");
                        break;
                }
                char cha=sec.get(2 + (4*i)).charAt(0);
                r = Integer.parseInt(sec.get(3 + (4*i)));
                p = Double.parseDouble(sec.get(1 + (4*i)));
                ((AirSystemManager) sm).createSection(a, id, r, cha, c, p);
            }

        }

    }

    private void changeSeatPrice() {

    }

    private void findTrips() {

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
        System.out.println("Enter file name to use for storing information: ");
        try {
            String fileout = in.nextLine();
            File fout = new File(fileout);
            PrintStream psOut = new PrintStream(fout);
            sm.displaySystemDetails(psOut);
        } catch (FileNotFoundException e) {
            System.out.println("File storing error.");
        }
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
                System.out.println("Unexpected input error.");
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
                System.out.println("Unexpected input error.");
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
                System.out.println("Unexpected input error.");
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
            System.out.println("AirLayout char (s, m, w): ");
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
                throw new IllegalArgumentException("Error in addTransportSection method");
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
                System.out.println("Unexpected input error.");
            }
            } catch (Exception e) {
                System.out.println("Unexpected input error");
            }
    }
}
