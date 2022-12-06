package buyer;

import admin.Admin;
import admin.Setup;
import admin.View;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

    private Integer buyerPhone;
    private List<Book> booking;

    public Integer getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(Integer buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public List<Book> getBooking() {
        return booking;
    }

    public void setBooking(List<Book> booking) {
        this.booking = booking;
    }


    public List<String> getAvailability(Admin admin, String input)
    {
        Availability availability;
        if(checkShowExist(admin,input)) {
            if (admin.getViewMap().containsKey(Integer.parseInt(input))) {
                availability = new Availability(admin.getSetupMap().get(Integer.parseInt(input)), admin.getViewMap().get(Integer.parseInt(input)));
            } else {
                availability = new Availability(admin.getSetupMap().get(Integer.parseInt(input)));
            }
            return availability.getSeatNumber();
        }
        return new ArrayList<>();
    }

    public boolean checkShowExist(Admin admin,String input)
    {
        return admin.getSetupMap().containsKey(Integer.parseInt(input));
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

        List<String> availableSeats = getAvailability(admin,String.valueOf(showNumber));
        availableSeats.retainAll(seatsSelection);
        if(availableSeats.equals(seatsSelection))
        {
            return true;
        }
        else {
            return false;
        }


    }

}
