package admin;

import java.util.List;

public class View {
    private Integer showNumber;
    private Integer tickNumber;
    private Integer buyerPhone;
    private List<String> seatNumber;

    public Integer getShowNumber() {
        return showNumber;
    }

    public void setShowNumber(Integer showNumber) {
        this.showNumber = showNumber;
    }

    public Integer getTickNumber() {
        return tickNumber;
    }

    public void setTickNumber(Integer tickNumber) {
        this.tickNumber = tickNumber;
    }

    public Integer getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(Integer buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public List<String> getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(List<String> seatNumber) {
        this.seatNumber = seatNumber;
    }
}