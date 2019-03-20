import UI.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Administrator Interface.\nTo begin, please select a department.\n");
        AdminUI ui=selectUI();
        ui.Interface();
    }

    private static AdminUI selectUI() {
        Scanner in=new Scanner(System.in);
        int selection;
        AdminUI ui=new AdminUI();
        while(true) {
            System.out.println("1. Airline Admin\n2.Cruise Admin\n");
            selection=ui.numSelection(in);
            if(selection==1) {
                return new AirlineAdmin();
            }
            else if(selection==2) {
                return new CruiseAdmin();
            }
            else {
                System.out.println("Invalid selection.");
            }
        }

    }

}
