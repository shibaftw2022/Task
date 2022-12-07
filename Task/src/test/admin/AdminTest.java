
import admin.Admin;
import admin.Setup;
import admin.View;
import org.junit.Test;


import static org.junit.Assert.*;

public class AdminTest {
    Admin admin = new Admin();
    int input = 0;
    @Test
    public void checkRowInput() {

        //When Rows input is 0
        input = 0;
        assertEquals(false,admin.checkRowInput(input));

        //When Rows input is 1
        input = 1;
        assertEquals(true,admin.checkRowInput(input));

        //When Rows input is 26
        input = 26;
        assertEquals(true,admin.checkRowInput(input));

        //When Rows input is greater than 26
        input = 27;
        assertEquals(false,admin.checkRowInput(input));
    }

    @Test
    public void checkSeatsInput() {


        //When Seats input is 0
        input = 0;
        assertEquals(false,admin.checkSeatsInput(input));

        //When Seats input is 1
        input = 1;
        assertEquals(true,admin.checkSeatsInput(input));

        //When Seats input is 10
        input = 10;
        assertEquals(true,admin.checkSeatsInput(input));

        //When Seats input is greater than 10
        input = 11;
        assertEquals(false,admin.checkSeatsInput(input));
        
    }


    @Test
    public void checkViewExist() {
        input = 1;
        //Check if the view for a show number exist.
        admin.getViewMap().put(input,new View());

        //When input is valid in the map for view
        assertEquals(true,admin.checkViewExist(input));

        input = 2;

        //When input is invalid in the map for view
        assertEquals(false,admin.checkViewExist(input));


    }

    @Test
    public void checkSetupExist() {
        input = 1;
        //Check if the setup for a show number exist.
        admin.getSetupMap().put(input,new Setup());

        //When input is valid in the map for setup
        assertEquals(true,admin.checkSetupExist(input));

        input = 2;

        //When input is invalid in the map for setup
        assertEquals(false,admin.checkSetupExist(input));

    }
}