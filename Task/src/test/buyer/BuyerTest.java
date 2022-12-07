

import admin.Admin;
import admin.Setup;
import admin.View;
import buyer.Buyer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BuyerTest {
    Admin admin = new Admin();
    Buyer buyer = new Buyer();
    int input = 0;
    @Test
    public void getAvailability() {

        //Test when admin got no setup and view and incorrect show number, return empty list
        assertEquals(new ArrayList<>(),buyer.getAvailability(admin,String.valueOf(input)));

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
        assertEquals(new ArrayList<>(Arrays.asList("A1","A2","B1","B2")),buyer.getAvailability(admin,String.valueOf(setup.getShowNumber())));

        //Test when admin got setup but no view and incorrect show number
        input = 2;
        assertEquals(new ArrayList<>(),buyer.getAvailability(admin,String.valueOf(input)));


        input = 1;
        View view = new View();
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

    }

//    @Test
//    public void checkShowExist() {
//    }
//
//    @Test
//    public void checkBookingExist() {
//    }
//
//    @Test
//    public void checkValidSeats() {
//    }
//
//    @Test
//    public void cancelBooking() {
//    }
//
//    @Test
//    public void checkValidTicket() {
//    }
}