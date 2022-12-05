package buyer;
import java.util.List;

public class Availability {
    private Integer showNumber;
    private List<String> seatNumber;

    public Integer getShowNumber() {
        return showNumber;
    }

    public void setShowNumber(Integer showNumber) {
        this.showNumber = showNumber;
    }

    public List<String> getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(List<String> seatNumber) {
        this.seatNumber = seatNumber;
    }
}