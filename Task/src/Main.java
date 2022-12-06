import admin.Admin;
import admin.Setup;
import admin.View;
import buyer.Availability;
import buyer.Book;
import buyer.Buyer;

import java.util.*;

public class Main {

//    public static Map<Integer,Setup> setupMap= new HashMap<Integer,Setup>();
//    public static Map<Integer, View> viewMap= new HashMap<Integer,View>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = "";
        boolean flag = true;
        Admin admin = new Admin();
        Buyer buyer = new Buyer();

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
                    adminPanel(admin);
                    break;
                case "2":
                    buyerPanel(admin,buyer);
                    break;
            }
            input = "";
        }
        while(!input.equals("3"));
    }

    public static void adminPanel(Admin admin) {

        Scanner sc = new Scanner(System.in);
        String input = "";
        boolean flag = true;

        do{
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
                        if (admin.checkRowInput(rows)) {
                            setup.setNumberRows(rows);
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
                        int seats = sc.nextInt();
                        if (admin.checkSeatsInput(seats)) {
                            setup.setNumberSeats(seats);
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

                System.out.println("Enter Cancellation Period (Minutes) : ");

                int mins = sc.nextInt();
                setup.setCancelMins(mins);

                if(!admin.getSetupMap().containsKey(setup.getShowNumber()))
                {
                    admin.getSetupMap().put(setup.getShowNumber(), setup);
                }
                sc.nextLine();
            break;
            //View
            case "2":
                //Enter Show Number
                System.out.println("Enter Show Number : ");
                input = sc.nextLine();
                //If it exits

                if(admin.getViewMap().containsKey(Integer.parseInt(input)))
                {
                    for(Book booking : admin.getViewMap().get(Integer.parseInt(input)).getBookings())
                    {
                        System.out.println("Show Number: " + booking.getShowNumber());
                        System.out.println("Ticket Number: " + booking.getTicketId());
                        System.out.println("Buyer Phone Number: " + booking.getPhoneNumber());
                        String seats = String.join(",",booking.getBookedSeats());
                        System.out.println("Seat Numbers: " + seats);
                    }
                }
                else
                {
                    System.out.println("Show Number does not exist.");
                }
                break;
        }
//            sc.nextLine();
            input = "";



        }while(true);
}



    public static void buyerPanel(Admin admin, Buyer buyer) {

        Scanner sc = new Scanner(System.in);
        String input = "";
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
                //Availability
                case "1":
                    //Show Number
                    System.out.println("Enter Show Number : ");
                    input = sc.nextLine();
                    System.out.println(buyer.getAvailability(admin,input));
                    break;
                //Book
                case "2":
                    //Create new Booking
                    Book book = new Book();
                    boolean phone = false;
                    //Set Show Number
                    System.out.println("Enter Show Number: ");
                    input = sc.nextLine();
                    if(buyer.checkShowExist(admin,input)) {
                        book.setShowNumber(Integer.parseInt(input));
                        //Set Phone Number
                        System.out.println("Enter Phone Number: ");
                        input = sc.nextLine();
                        //Check if phone exits in booking of the same show
                        phone = buyer.checkBookingExist(admin,book.getShowNumber(),Integer.parseInt(input));

                        if(phone)
                        {
                            System.out.println("Phone Number exist in current Booking.");
                            break;
                        }
                        book.setPhoneNumber(Integer.parseInt(input));
                        //Set Seats Number
                        System.out.println("Enter Seats Number: ");
                        input = sc.nextLine();
                        String[] seats = input.split(",");
                        book.setBookedSeats(new ArrayList<>(Arrays.asList(seats)));

                        //Set Cancel Time
                        Calendar currentTimeNow = Calendar.getInstance();
                        currentTimeNow.add(Calendar.MINUTE, admin.getSetupMap().get(book.getShowNumber()).getCancelMins());
                        book.setCancelTime(currentTimeNow.getTime());

                        //Create UUID for Show
                        book.setTicketId(UUID.randomUUID());
                        //Print ticket number
                        System.out.println(book.getTicketId());

                        admin.addView(book);
                    }
                    else
                    {
                        System.out.println("Invalid Show Number.");
                    }

                    break;

                case "3":
                    View showView = new View();
                    System.out.println("Enter Show Number to Cancel: ");
                    input = sc.nextLine();
                    //Check if it exits in view
                    if(admin.getViewMap().containsKey(Integer.parseInt(input)))
                    {
                        showView = admin.getViewMap().get(Integer.parseInt(input));

                        System.out.println("Enter Ticket Number to Cancel: ");
                        input = sc.nextLine();

                        //Check for the booking
                        for(Book booking : showView.getBookings())
                        {
                            if(booking.getTicketId().toString().equals(input))
                            {
                                //Check if time permits to cancel
                                Calendar currentTimeNow = Calendar.getInstance();
                                Date now = currentTimeNow.getTime();
                                if(now.before(booking.getCancelTime()))
                                {
                                    showView.getBookings().remove(booking);
                                    System.out.println("Ticket Cancelled");
                                    break;
                                }
                                else
                                {
                                    System.out.println("Ticket cannot be Cancelled as Time exceed Cancellation Time.");
                                    break;
                                }

                            }
                        }
                        System.out.println("Invalid Ticket Number.");
                    }
                    else if(admin.getSetupMap().containsKey(Integer.parseInt(input)))
                    {
                        System.out.println("Show number does not have any booking.");
                    }
                    else
                    {
                        System.out.println("Invalid Show Number.");
                    }


                    break;
            }

            input = "";



        }while(true);
    }

}