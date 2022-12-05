import admin.Admin;
import admin.Setup;
import buyer.Availability;
import buyer.Buyer;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static Admin admin = new Admin();
    public static Buyer buyer = new Buyer();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = "";
        int showNumber = 0;
        boolean flag = true;

        do {
            while (!(input.equals("1")) && !(input.equals("2"))) {
                System.out.println("Hello, kindly select the choice of user by the number : ");
                System.out.println("1) Admin.");
                System.out.println("2) Buyer.");
                System.out.println("3) Exit.");
                input = sc.nextLine();
            }

            switch (input) {
                case "1":
                    adminPanel();
                    break;
                case "2":
                    buyerPanel();
                    break;
            }
            input = "";
        }
        while(!input.equals("3"));
    }

    public static void adminPanel() {
        Scanner sc = new Scanner(System.in);
        String input = "";
        int showNumber = 0;
        boolean flag = true;

        do{
        System.out.println(input);
        while(!(input.equals("1") || input.equals("2") || input.equals("3"))) {
            System.out.println("Welcome to Admin Panel: Select choice of action");
            System.out.println("1) Setup:");
            System.out.println("2) View:");
            System.out.println("3) Back:");
            input =sc.nextLine();
        }
        if(input.equals("3"))
        {
            break;
        }

        switch(input) {
            case "1":
                //Show Number
                Setup setup = new Setup();
                do {
                    System.out.println("Enter Show Number:");
                    if (sc.hasNextInt()) {
                        setup.setShowNumber(sc.nextInt());
                        flag = false;
                    } else {
                        sc.nextLine();
                    }
                }
                while (flag);

                // Num of rows
                flag = true;
                sc.nextLine();
                do {
                    System.out.println("Enter Number of Rows (Maximum of 26 rows): ");
                    if (sc.hasNextInt()) {
                        int rows = sc.nextInt();
                        if (rows <= 26 && rows > 0) {
                            setup.setNumberRows(rows);
                            System.out.println(setup.getNumberRows());
                            flag = false;
                        } else {
                            continue;
                        }
                    } else {
                        sc.nextLine();
                    }
                }
                while (flag);

                flag = true;
                sc.nextLine();
                do {
                    System.out.println("Enter Number of Seats per Row (Maximum of 10 per Row): ");
                    if (sc.hasNextInt()) {
                        int cols = sc.nextInt();
                        if (cols <= 10 && cols > 0) {
                            setup.setNumberSeats(cols);
                            System.out.println(setup.getNumberSeats());
                            flag = false;
                        } else {
                            continue;
                        }
                    } else {
                        sc.nextLine();
                    }
                }
                while (flag);
                sc.nextLine();


                flag = true;
                do {
                    System.out.println("Enter Cancellation Period (Minutes) : ");
                    if (sc.hasNextInt()) {
                        int mins = sc.nextInt();
                        if (mins > 0) {
                            setup.setCancelMins(mins);
                            System.out.println(setup.getCancelMins());
                            flag = false;
                        } else {
                            continue;
                        }
                    } else {
                        sc.nextLine();
                    }
                }
                while (flag);
                admin.getSetups().add(setup);

            //View
            case "2":

        }
            sc.nextLine();
            input = "";



        }while(true);
}



    public static void buyerPanel() {
        List<Setup> setups = admin.getSetups();
        Scanner sc = new Scanner(System.in);
        String input = "";
        int showNumber = 0;
        boolean flag = true;

        do{
            while(!(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") )) {
                System.out.println("Welcome to Buyer Panel: Select choice of action");
                System.out.println("1) Availability:");
                System.out.println("2) Book:");
                System.out.println("3) Cancel:");
                System.out.println("4) Back:");
                input =sc.nextLine();
            }
            if(input.equals("4"))
            {
                break;
            }

            switch(input) {
                case "1":
                    //Show Number
                    for(int i =0; i <setups.size(); i++)
                    {
                        Availability availability = new Availability(setups.get(i));
                        System.out.println("Show Number : " + availability.getShowNumber());
                        System.out.println("Seat Available : " + availability.getSeatNumber());
                    }


                    //View
                case "2":

            }

            input = "";



        }while(true);
    }

}