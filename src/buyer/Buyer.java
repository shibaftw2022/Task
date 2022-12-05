package buyer;

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
}