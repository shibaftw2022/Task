package buyer;

import admin.Admin;
import admin.Setup;
import admin.View;

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


    public String getAvailability(Admin admin, String input)
    {
        Availability availability;
        if(admin.getSetupMap().containsKey(Integer.parseInt(input))) {
            if (admin.getViewMap().containsKey(Integer.parseInt(input))) {
                availability = new Availability(admin.getSetupMap().get(Integer.parseInt(input)), admin.getViewMap().get(Integer.parseInt(input)));
            } else {
                availability = new Availability(admin.getSetupMap().get(Integer.parseInt(input)));
            }
            return "Show Seats Availability : " + availability.getSeatNumber();
        }
        else {
            return "Invalid Show Number.";
        }
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

}
