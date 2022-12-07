
import admin.Admin;
import org.junit.Test;


import static org.junit.Assert.*;

public class AdminTest {

    @Test
    public void checkRowInput() {
        Admin admin = new Admin();
        int input = 0;

        //When Rows input is 0
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
        
    }

//    @Test
//    public void addView() {
//    }
//
//    @Test
//    public void checkViewExist() {
//    }
//
//    @Test
//    public void checkSetupExist() {
//    }
}