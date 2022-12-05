package buyer;
import admin.Setup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Availability {
    List<String> rows = new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
    List<String> seats = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9","10"));
    private Integer showNumber;
    private List<String> seatNumber;

    private Setup setup;

    public Availability(Setup setup)
    {
        this.setup = setup;
        this.showNumber = setup.getShowNumber();
        int setupRow = setup.getNumberRows();
        int setupSeat = setup.getNumberSeats();
        seatNumber = new ArrayList<>();

        for(int i =0; i < setupRow; i++)
        {
            for(int j =0; j < setupSeat; j++)
            {
               seatNumber.add(rows.get(i)+seats.get(j));
            }
        }

    }

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