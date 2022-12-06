package admin;

import buyer.Book;

import java.util.List;

public class View {
    private Integer showNumber;
   private List<Book> bookings;

    public Integer getShowNumber() {
        return showNumber;
    }

    public void setShowNumber(Integer showNumber) {
        this.showNumber = showNumber;
    }

    public List<Book> getBookings() {
        return bookings;
    }

    public void setBookings(List<Book> bookings) {
        this.bookings = bookings;
    }
}