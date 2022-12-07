

import admin.Admin;
import admin.Setup;
import admin.View;
import buyer.Book;
import buyer.Buyer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.UUID;

import static org.junit.Assert.*;

public class BuyerTest {
    Admin admin = new Admin();
    Buyer buyer = new Buyer();
    int input = 0;
    @Test
    public void getAvailability() {

        //Test when admin got no setup and view and incorrect show number, return empty list
        assertEquals(new ArrayList<>(),buyer.getAvailability(admin,input));

        input = 1;
        Setup setup = new Setup();
        //Set show number
        setup.setShowNumber(input);
        //Set Rows to 2
        input = 2;
        setup.setNumberRows(input);
        //Set Seats to 2
        setup.setNumberSeats(input);
        //Set Cancel Time to 2 mins
        setup.setCancelMins(input);
        //Set the setup into the Map within Admin
        admin.getSetupMap().put(setup.getShowNumber(),setup);


        //Test when admin got setup but no view and correct show number
        assertEquals(new ArrayList<>(Arrays.asList("A1","A2","B1","B2")),buyer.getAvailability(admin,setup.getShowNumber()));

        //Test when admin got setup but no view and incorrect show number
        input = 2;
        assertEquals(new ArrayList<>(),buyer.getAvailability(admin,input));


        input = 1;
        View view = new View();
        //Set show number
        view.setShowNumber(input);
        //Booking
        Book booking = new Book();
        //Set show number
        booking.setShowNumber(input);
        //Set phone number
        input = 88888888;
        booking.setPhoneNumber(input);
        //Set booked seats
        booking.setBookedSeats(new ArrayList<>(Arrays.asList("A1","A2")));
        //Set Cancel Date
        Calendar currentTimeNow = Calendar.getInstance();
        booking.setCancelTime(currentTimeNow.getTime());
        //Set ticket id
        booking.setTicketId(UUID.randomUUID());
        //Add booking to view
        view.setBookings(new ArrayList<Book>(Arrays.asList(booking)));
        input = 1;
        //Adding view to admin
        admin.getViewMap().put(input, view);

        //Test when admin got setup and view and correct show number
        assertEquals(new ArrayList<>(Arrays.asList("B1","B2")),buyer.getAvailability(admin,setup.getShowNumber()));

    }

    @Test
    public void checkShowExist() {
        admin = new Admin();
        input = 1;
        Setup setup = new Setup();
        //Set show number
        setup.setShowNumber(input);
        //Set Rows to 2
        input = 2;
        setup.setNumberRows(input);
        //Set Seats to 2
        setup.setNumberSeats(input);
        //Set Cancel Time to 2 mins
        setup.setCancelMins(input);
        //Set the setup into the Map within Admin
        admin.getSetupMap().put(setup.getShowNumber(),setup);

        //Show exist in setup
       assertEquals(true ,buyer.checkShowExist(admin,setup.getShowNumber()));

       //Show does not exist in setup
       input = 2;
       assertEquals(false ,buyer.checkShowExist(admin,input));
    }

    @Test
    public void checkBookingExist() {
        admin = new Admin();
        input = 1;
        View view = new View();
        //Set show number
        view.setShowNumber(input);
        //Booking
        Book booking = new Book();
        //Set show number
        booking.setShowNumber(input);
        //Set phone number
        input = 88888888;
        booking.setPhoneNumber(input);
        //Set booked seats
        booking.setBookedSeats(new ArrayList<>(Arrays.asList("A1","A2")));
        //Set Cancel Date
        Calendar currentTimeNow = Calendar.getInstance();
        booking.setCancelTime(currentTimeNow.getTime());
        //Set ticket id
        booking.setTicketId(UUID.randomUUID());
        //Add booking to view
        view.setBookings(new ArrayList<Book>(Arrays.asList(booking)));
        input = 1;
        //Adding view to admin
        admin.getViewMap().put(input, view);

        //Check if the phone number booking for a show number exist
        assertEquals(true,buyer.checkBookingExist(admin,booking.getShowNumber(),booking.getPhoneNumber()));
        //When phone number does not exist in any booking
        input = 12345678;
        assertEquals(false,buyer.checkBookingExist(admin,booking.getShowNumber(),input));
    }

    @Test
    public void checkValidSeats() {

        admin = new Admin();
        input = 1;
        Setup setup = new Setup();
        //Set show number
        setup.setShowNumber(input);
        //Set Rows to 2
        input = 2;
        setup.setNumberRows(input);
        //Set Seats to 2
        setup.setNumberSeats(input);
        //Set Cancel Time to 2 mins
        setup.setCancelMins(input);
        //Set the setup into the Map within Admin
        admin.getSetupMap().put(setup.getShowNumber(),setup);

        //Select seats that are valid
        assertEquals(true,buyer.checkValidSeats(admin,setup.getShowNumber(),new ArrayList<>(Arrays.asList("A1","B1"))));

        //Select Seats that are invalid/out or range
        assertEquals(false,buyer.checkValidSeats(admin,setup.getShowNumber(),new ArrayList<>(Arrays.asList("J1","B1"))));

    }

    @Test
    public void cancelBooking() {

        input = 1;
        View view = new View();
        //Set show number
        view.setShowNumber(input);
        //Booking
        Book booking = new Book();
        //Set show number
        booking.setShowNumber(input);
        //Set phone number
        input = 88888888;
        booking.setPhoneNumber(input);
        //Set booked seats
        booking.setBookedSeats(new ArrayList<>(Arrays.asList("A1","A2")));
        //Set Cancel Date
        Calendar currentTimeNow = Calendar.getInstance();
        currentTimeNow.add(Calendar.MINUTE, 2);
        booking.setCancelTime(currentTimeNow.getTime());
        //Set ticket id
        UUID ticketId = UUID.randomUUID();
        booking.setTicketId(ticketId);
        //Add booking to view
        view.setBookings(new ArrayList<Book>(Arrays.asList(booking)));
        System.out.println(view.getBookings().size());

        //Cancellation is possible as the time for cancellation is 2 mins.
        assertEquals(true,buyer.cancelBooking(view,ticketId.toString()));

        //Cancellation is not possible as the time for cancellation is -2 mins.
        currentTimeNow = Calendar.getInstance();
        currentTimeNow.add(Calendar.MINUTE, -2);
        booking.setCancelTime(currentTimeNow.getTime());
        view.setBookings(new ArrayList<Book>(Arrays.asList(booking)));
        assertEquals(false,buyer.cancelBooking(view,ticketId.toString()));

    }

    @Test
    public void checkValidTicket() {
        //Booking
        Book booking = new Book();
        //Set show number
        booking.setShowNumber(input);
        //Set phone number
        input = 88888888;
        booking.setPhoneNumber(input);
        //Set booked seats
        booking.setBookedSeats(new ArrayList<>(Arrays.asList("A1","A2")));
        //Set Cancel Date
        Calendar currentTimeNow = Calendar.getInstance();
        currentTimeNow.add(Calendar.MINUTE, 2);
        booking.setCancelTime(currentTimeNow.getTime());
        //Set ticket id
        UUID ticketId = UUID.randomUUID();
        booking.setTicketId(ticketId);

        buyer.getBooking().add(booking);

        //Correct ticket ID the buyer have
        assertEquals(true,buyer.checkValidTicket(ticketId.toString())) ;
        //Incorrect ticket ID the buyer have
        assertEquals(false,buyer.checkValidTicket(UUID.randomUUID().toString())) ;

    }
}