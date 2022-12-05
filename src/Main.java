import admin.Admin;
import admin.Setup;
import buyer.Buyer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin();
        Buyer buyer = new Buyer();
        String input = "";
        int showNumber = 0;
        boolean flag = true;
        while(!(input.equals("1")) && !(input.equals("2"))) {
            System.out.println("Hello, kindly select the choice of user by the number : ");
            System.out.println("1) Admin.");
            System.out.println("2) Buyer.");
            input =sc.nextLine();
        }

        switch(input)   {
            case "1" :
                input = "";
                while(!(input.equals("1")) && !(input.equals("2"))) {
                    System.out.println("Welcome to Admin Panel: Select choice of action");
                    System.out.println("1) Setup:");
                    System.out.println("2) View:");
                    input =sc.nextLine();
                }

                switch(input)
                {
                    case "1":
                        //Show Number
                        Setup setup = new Setup();
                        do{
                            System.out.println("Enter Show Number:");
                            if(sc.hasNextInt())
                            {
                                setup.setShowNumber(sc.nextInt());
                                flag = false;
                            }
                            else {
                                sc.nextLine();
                            }
                        }
                        while(flag);

                        // Num of rows
                        flag = true;
                        sc.nextLine();
                        do{
                            System.out.println("Enter Number of Rows (Maximum of 26 rows): ");
                            if(sc.hasNextInt())
                            {
                                int rows = sc.nextInt();
                                if(rows <= 26 && rows > 0) {
                                    setup.setNumberRows(rows);
                                    System.out.println(setup.getNumberRows());
                                    flag = false;
                                }
                                else
                                {
                                    continue;
                                }
                            }
                            else {
                                sc.nextLine();
                            }
                        }
                        while(flag);

                        flag = true;
                        sc.nextLine();
                        do{
                            System.out.println("Enter Number of Seats per Row (Maximum of 10 per Row): ");
                            if(sc.hasNextInt())
                            {
                                int cols = sc.nextInt();
                                if(cols <= 10 && cols > 0) {
                                    setup.setNumberSeats(cols);
                                    System.out.println(setup.getNumberSeats());
                                    flag = false;
                                }
                                else
                                {
                                    continue;
                                }
                            }
                            else {
                                sc.nextLine();
                            }
                        }
                        while(flag);
                        sc.nextLine();


                        flag = true;
                        do{
                            System.out.println("Enter Cancellation Period (Minutes) : ");
                            if(sc.hasNextInt())
                            {
                                int mins = sc.nextInt();
                                if(mins > 0) {
                                    setup.setCancelMins(mins);
                                    System.out.println(setup.getCancelMins());
                                    flag = false;
                                }
                                else
                                {
                                    continue;
                                }
                            }
                            else {
                                sc.nextLine();
                            }
                        }
                        while(flag);



                }


                break;
            case "2" :
                System.out.println("Welcome to Buyer Panel:");
                break;

        }

    }




}