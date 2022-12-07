package buyer;

import admin.Admin;
import admin.Setup;
import admin.View;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Buyer {
    
    private List<Book> booking;

    public Buyer(){
        this.booking = new ArrayList<>();
    }

    public List<Book> getBooking() {
        return booking;
    }

    public void setBooking(List<Book> booking) {
        this.booking = booking;
    }


    public List<String> getAvailability(Admin admin, int input)
    {
        Availability availability;
        if(checkShowExist(admin,input)) {
            if (admin.getViewMap().containsKey(input)) {
                availability = new Availability(admin.getSetupMap().get(input), admin.getViewMap().get(input));
            } else {
                availability = new Availability(admin.getSetupMap().get(input));
            }
            return availability.getSeatNumber();
        }
        return new ArrayList<>();
    }

    public boolean checkShowExist(Admin admin,int input)
    {
        return admin.getSetupMap().containsKey(input);
    }

    public boolean checkBookingExist(Admin admin, int showNumber, int phoneNumber) {
        if (admin.getViewMap().containsKey(showNumber)) {
            View view = admin.getViewMap().get(showNumber);
            for (Book booking : view.getBookings()) {
                if (booking.getPhoneNumber() == phoneNumber) {
                    return true;
                }
            }
        }
            return false;
    }

    public boolean checkValidSeats(Admin admin, int showNumber,List<String> seatsSelection)
    {

        List<String> availableSeats = getAvailability(admin,showNumber);
        availableSeats.retainAll(seatsSelection);
        if(availableSeats.equals(seatsSelection))
        {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean cancelBooking(View view, String ticketId)
    {
        for(Book booking : view.getBookings())
        {
            if(booking.getTicketId().toString().equals(ticketId))
            {
                //Check if time permits to cancel
                Calendar currentTimeNow = Calendar.getInstance();
                Date now = currentTimeNow.getTime();
                if(now.before(booking.getCancelTime()))
                {
                    view.getBookings().remove(booking);
                    this.booking.remove(booking);
                    return true;

                }
                else
                {
                    return false;
                 
                }

            }
        }
           return false;
    }

    public boolean checkValidTicket(String ticketId)
    {
        for(Book booking : booking)
        {
            if(booking.getTicketId().toString().equals(ticketId))
            {
                return true;
            }
            else{
                return false;
            }
        }
        return false;

    }

}
